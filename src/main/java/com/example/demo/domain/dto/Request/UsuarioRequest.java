package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.enums.CategoriaDespesa;
import com.example.demo.domain.model.enums.StatusUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UsuarioRequest(
        @NotBlank(message = "Campo Obrigatorio")
        String  nome,

        @NotBlank(message = "Campo Obrigatorio")
        @Email(message = "Formato de e-mail inválido")
        String email,

        @NotBlank(message = "Campo Obrigatorio")

        String telefone,

        @NotBlank(message = "Campo Obrigatorio")
        @Size(min = 5, message = "A senha deve ter no minimo 5 carateres")
        String senha,

        @NotNull(message = "Campo Obrigatorio")
        StatusUsuario statusUsuario
) {
}
