package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.UsuarioRequest;
import com.example.demo.domain.dto.Response.MoradorReponse;
import com.example.demo.domain.dto.Response.UsuarioResponse;
import com.example.demo.domain.model.Morador;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.model.enums.StatusUsuario;
import com.example.demo.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService{

    @Autowired

    private UsuarioRepository usuarioRepository;

    @Autowired PasswordEncoder passwordEncoder;


    public UsuarioResponse cadastrarUsuario(UsuarioRequest request){

        Usuario user= new Usuario();

        user.setNome(request.nome());
        user.setEmail(request.email());
        user.setSenha(passwordEncoder.encode(request.senha()));
        user.setTelefone(request.Telefone());
        user.setStatusUsuario(StatusUsuario.ROLE_ADMIN);

        return toResponse(usuarioRepository.save(user));
    }
    public UsuarioResponse atualizar(Integer id, UsuarioRequest request){
        // Busca o usuário no banco usando o ID enviado na requisição
        Usuario user= usuarioRepository.findById(id).orElseThrow(()->
                new RuntimeException("Id do Usuario não encontrado"));

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
    public List<UsuarioResponse>buscarUsuario(String nome){
        List<Usuario> user=usuarioRepository.findByNomeContainingIgnoreCase(nome);

        return user.stream().map(this::toResponse).toList();
    }

    public UsuarioResponse listarporId(Integer id){
        Usuario user= usuarioRepository.findById(id).orElseThrow(()->
                new RuntimeException("Id do Usuario não encontrado"));

        return toResponse(user);
    }

    public void apagarUsuario(Integer id){
        Usuario user= usuarioRepository.findById(id).orElseThrow(()->
                new RuntimeException("Id do Usuario não encontrado"));

        usuarioRepository.delete(user);
    }
    private UsuarioResponse toResponse(Usuario user){
        return new UsuarioResponse(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getTelefone(),
                user.getStatusUsuario()
        );
    }

}
