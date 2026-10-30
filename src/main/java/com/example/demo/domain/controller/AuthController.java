package com.example.demo.domain.controller;

import com.example.demo.domain.dto.Request.AuthRequest;
import com.example.demo.domain.dto.Request.UsuarioRequest;
import com.example.demo.domain.dto.Response.AuthResponse;
import com.example.demo.domain.dto.Response.UsuarioResponse;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.security.JWTokensService;
import com.example.demo.domain.service.AuthService;
import com.example.demo.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.net.PasswordAuthentication;

@RestController
@CrossOrigin("*")
@RequestMapping("api/auth)")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JWTokensService jwTokensService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse>login(@RequestBody AuthRequest request){
        var userSenha=new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        var auteticacao =authenticationManager.authenticate(userSenha);

        var user=(Usuario) auteticacao.getPrincipal();

        //GERAR o token de verdade para o usuário!
        String token= jwTokensService.gerarToken(user);

        UsuarioResponse usuarioResponse= new UsuarioResponse(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getTelefone(),
                user.getStatusUsuario()
        );

        // Devolve os dados no AuthResponse com o status 202 Accepted
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new AuthResponse(usuarioResponse, token));

    }
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioRequest request){
        return new ResponseEntity<>(usuarioService.cadastrarUsuario(request), HttpStatus.CREATED);
    }
}
