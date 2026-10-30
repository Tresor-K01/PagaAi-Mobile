package com.example.demo.domain.controller;

 import com.example.demo.domain.dto.Request.UsuarioRequest;
import com.example.demo.domain.dto.Response.UsuarioResponse;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.model.enums.StatusUsuario;
import com.example.demo.domain.repository.UsuarioRepository;
 import com.example.demo.domain.service.UsuarioService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.stereotype.Service;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;
    
@RestController
@CrossOrigin("*")
@RequestMapping("api/user")

public class UsuarioController {

    @Autowired

    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/nome")
    public ResponseEntity<List<UsuarioResponse>> buscarUsuario(String nome){

        return new ResponseEntity<>(usuarioService.buscarUsuario(nome), HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse>atualizar(@RequestBody UsuarioRequest request, @PathVariable Integer id){
        return new ResponseEntity<>(usuarioService.atualizar(id, request),HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse>listarporId(@PathVariable Integer id){
        return new ResponseEntity<>(usuarioService.listarporId(id), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarMorador(){
        return new ResponseEntity<>(usuarioService.listarMorador(),HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>apagar(@PathVariable Integer id){
        usuarioService.apagarUsuario(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
