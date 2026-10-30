package com.example.demo.domain.security;

import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import java.io.IOException;
import java.util.Optional;


@Component
public class JWTokens extends OncePerRequestFilter {
    @Autowired
    private JWTokensService jwTokensService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var token=this.recoverToken(request);

        if(token !=null){
            var subject= jwTokensService.validarToken(token);

            if(!subject.isEmpty()){
                Optional<Usuario> user=usuarioRepository.findByEmail(subject);

                if(user.isPresent()){
                    var autenticacao=new UsernamePasswordAuthenticationToken(user.get(), null,
                            user.get().getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(autenticacao);

                }
            }
        }
        filterChain.doFilter(request, response);
    }
private String recoverToken(HttpServletRequest request){
        var autorizacao=request.getHeader("Autorization");

        if (autorizacao==null){
            return null;
        }
        if(autorizacao.toLowerCase().startsWith("bearer")){
            return autorizacao.substring(7).trim();
        }
        return autorizacao.trim();
}
}
