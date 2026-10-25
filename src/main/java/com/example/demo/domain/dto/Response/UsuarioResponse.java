package com.example.demo.domain.dto.Response;

import com.example.demo.domain.model.enums.StatusUsuario;

public record UsuarioResponse(
        Integer id,
        String  nome,
        String email,
        String Telefone,
        String senha,
        StatusUsuario statusUsuario
) {
}
