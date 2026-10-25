package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.UsuarioRequest;
import com.example.demo.domain.dto.Response.UsuarioResponse;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.model.enums.StatusUsuario;
import com.example.demo.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService{

    @Autowired

    private UsuarioRepository usuarioRepository;


    public UsuarioResponse cadastrarUsuario(UsuarioRequest request){

        Usuario user= new Usuario();

        user.setNome(request.nome());
        user.setEmail(request.email());
        user.setSenha(request.senha());
        user.setTelefone(request.Telefone());
        user.setStatusUsuario(StatusUsuario.ROLE_ADMIN);

        return toResponse(usuarioRepository.save(user));
    }
    public List<UsuarioResponse> listarMorador(){
        return usuarioRepository.findAll().stream().map(this::toResponse).toList();
    }
    private UsuarioResponse toResponse(Usuario user){
        return new UsuarioResponse(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getSenha(),
                user.getTelefone(),
                user.getStatusUsuario()
        );
    }

}
