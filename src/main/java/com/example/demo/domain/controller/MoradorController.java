package com.example.demo.domain.controller;

import com.example.demo.domain.dto.Request.MoradorRequest;
import com.example.demo.domain.dto.Request.UsuarioRequest;
import com.example.demo.domain.dto.Response.MoradorReponse;
import com.example.demo.domain.dto.Response.UsuarioResponse;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.model.enums.StatusUsuario;
import com.example.demo.domain.repository.MoradorRepository;
import com.example.demo.domain.repository.UsuarioRepository;
import com.example.demo.domain.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping()
public class MoradorController {

    @Autowired

    private MoradorRepository moradorRepository;

    private MoradorService moradorService;


    @PostMapping
    public ResponseEntity<MoradorReponse> cadastrarMoraodor(MoradorRequest request) {

        return new ResponseEntity<>(moradorService.cadastrarMorador(request), HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<MoradorReponse>>listarMoradores(){
        return new ResponseEntity<>(moradorService.listarMorador(), HttpStatus.OK);
    }
    /*
    @GetMapping("/{id}")
    public ResponseEntity<MoradorReponse>listarporId(Integer id){
        return new ResponseEntity<>(moradorService.listarPorId(id), HttpStatus.OK);
    }

     */
}