package com.example.demo.domain.dto.Response;

import com.example.demo.domain.model.Usuario;

public record MoradorReponse(
        Integer id,
        Usuario usuario,
        String numero_do_quarto
) {
}
