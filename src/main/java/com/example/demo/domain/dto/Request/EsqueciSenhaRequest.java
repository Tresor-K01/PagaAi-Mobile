package com.example.demo.domain.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record EsqueciSenhaRequest(
        @NotBlank(message = "Campo obrigatorio")
        @Email(message = "Formato de email invalido")
        String email
) {
}
