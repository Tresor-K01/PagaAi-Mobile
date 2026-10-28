package com.example.demo.domain.service;

import com.example.demo.domain.dto.Response.DespesasResponse;
import com.example.demo.domain.dto.Response.ObrigacoesResponse;
import com.example.demo.domain.dto.Response.TotalDespesasResponse;
import com.example.demo.domain.model.Despesas;
import com.example.demo.domain.repository.DespesaRepository;
import com.example.demo.domain.repository.ObrigacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TotalDespesasService {

    @Autowired
    private DespesaRepository despesaRepository;

    @Autowired
    private ObrigacoesRepository obrigacoesRepository;



}
