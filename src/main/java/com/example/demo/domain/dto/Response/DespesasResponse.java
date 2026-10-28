package com.example.demo.domain.dto.Response;

import com.example.demo.domain.model.enums.CategoriaDespesa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DespesasResponse(
        Integer id,
        String nome,
        CategoriaDespesa categoria,
        LocalDate data,
        BigDecimal valor
) {
}
