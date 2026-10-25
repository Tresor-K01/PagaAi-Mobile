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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DespesasService {

    @Autowired

    private DespesaRepository despesaRepository;


    public DespesasResponse cadastrarDespesas(DespesasRequest request){

        Despesas desp = new Despesas();

        desp.setCategoriaDespesa(request.categoria());
        desp.setValor(request.valor());

        return toResponse(despesaRepository.save(desp));
    }
    public List<DespesasResponse> listarDespesas(){
        return despesaRepository.findAll().stream().map(this::toResponse).toList();
    }
    private DespesasResponse toResponse(Despesas desp){
        return new DespesasResponse(
                desp.getId(),
                desp.getCategoriaDespesa(),
                desp.getData().toLocalDate(),
                desp.getValor()
        );
    }

}
