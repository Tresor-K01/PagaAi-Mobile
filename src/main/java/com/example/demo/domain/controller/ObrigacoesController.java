package com.example.demo.domain.controller;


import com.example.demo.domain.dto.Request.ObrigacoesRequest;
import com.example.demo.domain.dto.Response.ObrigacoesResponse;
import com.example.demo.domain.dto.Response.TotalDespesasResponse;
import com.example.demo.domain.service.ObrigacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/obrigacoes")
public class ObrigacoesController {

    @Autowired
    private ObrigacoesService obrigacoesService;


    @PostMapping
    public ResponseEntity<ObrigacoesResponse> criarObrigacoes(ObrigacoesRequest request) {
        return new ResponseEntity<>(obrigacoesService.criar(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<TotalDespesasResponse> listarObrigacoes() {

        return new ResponseEntity<>(obrigacoesService.listarObrigacoes(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>apagar(@PathVariable Integer id){
        obrigacoesService.apagarObr(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}