package com.example.demo.domain.security;

 import com.example.demo.domain.dto.Request.DespesasRequest;
 import com.example.demo.domain.dto.Response.DespesasResponse;
 import com.example.demo.domain.repository.DespesaRepository;
 import com.example.demo.domain.service.DespesasService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.config.Customizer;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.http.SessionCreationPolicy;
 import org.springframework.security.web.SecurityFilterChain;
 import org.springframework.web.bind.annotation.*;

 import java.lang.management.ManagementFactory;
 import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(csrf->csrf.disable())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize-> authorize.anyRequest().permitAll()).build();
    }

}
