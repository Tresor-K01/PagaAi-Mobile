package com.example.demo.domain.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthRequest(
        @NotBlank(message = "Campo obrigatorio")
        String email,

        @NotBlank(message = "Campo obrigatorio")
        String senha
) {
}
