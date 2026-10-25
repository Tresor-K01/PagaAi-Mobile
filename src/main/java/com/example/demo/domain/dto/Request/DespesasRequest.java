package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.enums.CategoriaDespesa;

import java.math.BigDecimal;

public record DespesasRequest(
        CategoriaDespesa categoria,
        BigDecimal valor
) {
}
