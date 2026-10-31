package com.example.demo.domain.exceptions;


import com.example.demo.domain.config.DadoValidacao;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.method.MethodValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptions {

    //Trata os erros 404
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DadoValidacao> tratarErros404(EntityNotFoundException e){
        DadoValidacao validacao=new DadoValidacao(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso Não Encotrado",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validacao);
    }
    //. Tratamento para erros de validação de campos (@Valid no DTO)
    @ExceptionHandler(MethodValidationException.class)
    public ResponseEntity<DadoValidacao>ValidationExceptions(MethodValidationException e){
        DadoValidacao validacao= new DadoValidacao(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro de Validação",
                "Um ou mais campos preenchidos são inválidos."
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validacao);
    }
    // Tratamento genérico para qualquer outro erro inesperado (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<DadoValidacao> tratarErro500(Exception e){
        DadoValidacao validacao= new DadoValidacao(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "ERRO NO SERVIDOR",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(validacao);
    }
    //tratar erros de Usuarios
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<DadoValidacao>userNotFound(UsernameNotFoundException e){
        DadoValidacao validacao= new DadoValidacao(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "USUARIO NOT FOUND",
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validacao);
    }
}
