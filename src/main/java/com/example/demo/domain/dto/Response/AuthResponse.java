package com.example.demo.domain.dto.Response;

public record AuthResponse(
        UsuarioResponse usuarioResponse,
        String token
) {
}
