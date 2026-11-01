package com.example.demo.domain.service;

import com.example.demo.domain.dto.Request.EsqueciSenhaRequest;
import com.example.demo.domain.dto.Request.ResetSenhaRequest;
import com.example.demo.domain.model.NovaSenha;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.NovaSenhaRepository;
import com.example.demo.domain.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NovaSenhaRepository novaSenhaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return usuarioRepository.findByEmail(username).orElseThrow(
                ()->new UsernameNotFoundException("Usuario não encontrado")
        );
    }

    //metodo para solicitar nova senha
    public void solicitarNovaSenha(EsqueciSenhaRequest request){


            // Se não existir, buscar o Usuario primeiro para associar
            Usuario user=usuarioRepository.findByEmail(request.email()).orElseThrow(
                    ()->new UsernameNotFoundException("Usuario não encontrado"));

// Procura se já existe um token anterior para este utilizador, senão cria um novo
        NovaSenha novaSenha=novaSenhaRepository.findByUsuario_Email(request.email()).
                orElseGet(()->{
                 NovaSenha   novoregistro=new NovaSenha();
                    novoregistro.setUsuario(user);
                    return novoregistro;
                });




        // Gera um token aleatório e define expiração (ex: 15 min)
        String token = UUID.randomUUID().toString();

        novaSenha.setToken(token);
        novaSenha.setResetTokenExpiration(LocalDateTime.now().plusMinutes(15));

        novaSenhaRepository.save(novaSenha);
    }

    //Redefinir senha
    public void redefinirSenha(ResetSenhaRequest request){
        NovaSenha novaSenha=novaSenhaRepository.findByToken(request.token())
                .orElseThrow(()->new IllegalArgumentException("Token invalido"));

        if(novaSenha.getResetTokenExpiration().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Token Expirado");
        }
        Usuario user = novaSenha.getUsuario();
        user.setSenha(passwordEncoder.encode(request.novaSenha()));
        usuarioRepository.save(user);

        // Apaga o token usado para que não possa ser reutilizado
        novaSenhaRepository.delete(novaSenha);
    }

}
