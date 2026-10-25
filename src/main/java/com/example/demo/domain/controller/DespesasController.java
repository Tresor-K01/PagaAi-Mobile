package com.example.demo.domain.controller;

 import com.example.demo.domain.dto.Request.UsuarioRequest;
import com.example.demo.domain.dto.Response.UsuarioResponse;
 import com.example.demo.domain.repository.UsuarioRepository;
 import com.example.demo.domain.service.UsuarioService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")

public class DespesasController {

    @Autowired

    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(UsuarioRequest request){

        return new ResponseEntity<>(usuarioService.cadastrarUsuario(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarMorador(){
        return new ResponseEntity<>(usuarioService.listarMorador(),HttpStatus.OK);

    }

}
