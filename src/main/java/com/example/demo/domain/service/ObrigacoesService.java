package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.MoradorRequest;
import com.example.demo.domain.dto.Request.ObrigacoesRequest;
import com.example.demo.domain.dto.Response.DespesasResponse;
import com.example.demo.domain.dto.Response.MoradorReponse;
import com.example.demo.domain.dto.Response.ObrigacoesResponse;
import com.example.demo.domain.dto.Response.TotalDespesasResponse;
import com.example.demo.domain.model.Despesas;
import com.example.demo.domain.model.Morador;
import com.example.demo.domain.model.Obrigacoes;
import com.example.demo.domain.repository.DespesaRepository;
import com.example.demo.domain.repository.MoradorRepository;
import com.example.demo.domain.repository.ObrigacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ObrigacoesService {


    @Autowired
    private ObrigacoesRepository obrigacoesRepository;

    @Autowired
    private DespesaRepository despesaRepository;


    public ObrigacoesResponse criar(ObrigacoesRequest request) {

        Despesas desp = despesaRepository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Despesas não encontrado"));


        // 2. Cria a entidade Obrigacoes
        Obrigacoes obr = new Obrigacoes();
        obr.setDespesas(desp);
        obr.setDataObrigacao(java.time.LocalDate.now());
        obr.setDataVencimento(java.time.LocalDate.now());

        return toResponse(obrigacoesRepository.save(obr));
    }

    public TotalDespesasResponse listarObrigacoes() {


        List<ObrigacoesResponse> obrigacoes = obrigacoesRepository.findAll().stream().map(this::toResponse).toList();


        // 1. Calcula o total das despesas diretamente no service
        BigDecimal valorTotalDespesas = obrigacoes.stream()
                .map(ObrigacoesResponse::valorDevido)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return new TotalDespesasResponse(obrigacoes, valorTotalDespesas);

    }

    public ObrigacoesResponse listarPorId(Integer id) {
        Obrigacoes obr = obrigacoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id não Encontrado"));

        return toResponse(obr);
    }

    public void apagarObr(Integer id) {
        Obrigacoes obr = obrigacoesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Obrigação não encontrada"));

        obrigacoesRepository.delete(obr);

    }

    private ObrigacoesResponse toResponse(Obrigacoes obr){

        DespesasResponse desp= null;
        if(obr.getDespesas() !=null) {
            Despesas despesas = obr.getDespesas();
            desp = new DespesasResponse(
                    despesas.getId(),
                   despesas.getNome(),
                    despesas.getCategoriaDespesa(),
                    despesas.getData().toLocalDate(),
                    despesas.getValor()
            );
        }

        return new ObrigacoesResponse(
                obr.getId(),
                desp,
                obr.getDataObrigacao(),
                obr.getDataVencimento(),
                obr.getValorDevido()

        );
    }

}
