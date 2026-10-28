package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.enums.CategoriaDespesa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record DespesasRequest(
        String nome,
        CategoriaDespesa categoria,
        BigDecimal valor

) {
}
