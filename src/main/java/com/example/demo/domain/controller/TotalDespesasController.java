package com.example.demo.domain.controller;


import com.example.demo.domain.dto.Response.TotalDespesasResponse;
import com.example.demo.domain.service.TotalDespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("api/total")
public class TotalDespesasController {

    @Autowired
    private TotalDespesasService totalDespesasService;



}
