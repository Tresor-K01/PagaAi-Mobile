package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.enums.CategoriaDespesa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DespesasRequest(
        @NotBlank(message = "Campo obrigatorio")
        String nome,

        @NotNull(message = "Campo obrigatorio")
        CategoriaDespesa categoria,

        @NotNull(message = "Campo obrigatorio")
        BigDecimal valor

) {
}
