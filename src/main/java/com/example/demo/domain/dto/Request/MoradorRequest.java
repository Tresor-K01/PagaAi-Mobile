package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.Usuario;

public record MoradorRequest(
        Usuario usuario,
        String numero_do_quarto
) {
}
