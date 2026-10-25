package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.enums.CategoriaDespesa;
import com.example.demo.domain.model.enums.StatusUsuario;

import java.math.BigDecimal;

public record UsuarioRequest(
        String  nome,
        String email,
        String Telefone,
        String senha,
        StatusUsuario statusUsuario
) {
}
