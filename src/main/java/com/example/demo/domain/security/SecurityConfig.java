package com.example.demo.domain.security;

 import com.example.demo.domain.dto.Request.DespesasRequest;
 import com.example.demo.domain.dto.Response.DespesasResponse;
 import com.example.demo.domain.repository.DespesaRepository;
 import com.example.demo.domain.service.DespesasService;
 import io.swagger.v3.oas.models.Components;
 import io.swagger.v3.oas.models.OpenAPI;
 import io.swagger.v3.oas.models.security.SecurityRequirement;
 import io.swagger.v3.oas.models.security.SecurityScheme;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.authentication.AuthenticationManager;
 import org.springframework.security.config.Customizer;
 import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.config.http.SessionCreationPolicy;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Bean
    public OpenAPI customer(){
     return new OpenAPI()
             .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
             .components(new Components()
             .addSecuritySchemes("bearerAuth",
                     new SecurityScheme()
                             .type(SecurityScheme.Type.HTTP)
                             .scheme("bearer")
                             .bearerFormat("JWT")));
    }
    @Bean
 public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
 public PasswordEncoder passwordEncoder(){
     return new BCryptPasswordEncoder();
    }
}
