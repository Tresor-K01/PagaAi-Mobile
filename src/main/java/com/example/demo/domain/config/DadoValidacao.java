package com.example.demo.domain.config;

import java.time.LocalDateTime;

public record DadoValidacao (
        LocalDateTime timeStamp,
        int status,
        String error,
        String messagem
){
}
