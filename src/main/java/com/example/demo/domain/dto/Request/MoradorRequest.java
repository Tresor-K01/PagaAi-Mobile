package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MoradorRequest(
        @NotNull(message = "Campo Obrigatorio")
       Integer usuarioId,
        @NotBlank(message = "Campo Obrigatorio")
        String numeroDoQuarto
) {
}
