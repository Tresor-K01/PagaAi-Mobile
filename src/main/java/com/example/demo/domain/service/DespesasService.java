package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.DespesasRequest;
import com.example.demo.domain.dto.Request.MoradorRequest;
import com.example.demo.domain.dto.Response.DespesasResponse;
import com.example.demo.domain.dto.Response.MoradorReponse;
import com.example.demo.domain.model.Despesas;
import com.example.demo.domain.model.Morador;
import com.example.demo.domain.repository.DespesaRepository;
import com.example.demo.domain.repository.MoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DespesasService {

    @Autowired

    private DespesaRepository despesaRepository;


    public DespesasResponse cadastrarDespesas(DespesasRequest request){

        Despesas desp = new Despesas();

        desp.setNome(request.nome());
        desp.setCategoriaDespesa(request.categoria());
        desp.setValor(request.valor());

        // busca a data e hora do servidor/notebook
        desp.setData(java.time.LocalDateTime.now());

        return toResponse(despesaRepository.save(desp));
    }

    public DespesasResponse atualizarDespesas(Integer id, DespesasRequest request){
        Despesas desp = despesaRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Despesa não encontrado")
        );
        Despesas despesas = new Despesas();

        desp.setNome(request.nome());
        desp.setCategoriaDespesa(request.categoria());
        desp.setValor(request.valor());

        // busca a data e hora do servidor/notebook
        desp.setData(java.time.LocalDateTime.now());

        return toResponse(despesaRepository.save(despesas));
    }

    public List<DespesasResponse> listarDespesas(){
        return despesaRepository.findAll().stream().map(this::toResponse).toList();
    }
    public DespesasResponse listarPorId(Integer id){
        Despesas desp = despesaRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Despesa não encontrado")
        );
        return toResponse(desp);
    }
    public void apagarDespesas(Integer id){
        Despesas desp = despesaRepository.findById(id).orElseThrow(
                ()->new RuntimeException("Despesa não encontrado")
        );
        despesaRepository.delete(desp);
    }
    private DespesasResponse toResponse(Despesas desp){
        return new DespesasResponse(
                desp.getId(),
                desp.getNome(),
                desp.getCategoriaDespesa(),
                desp.getData().toLocalDate(),
                desp.getValor()
        );
    }

}
