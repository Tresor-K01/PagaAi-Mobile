package com.example.demo.domain.dto.Response;

import com.example.demo.domain.model.Morador;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.model.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PagamentoResponse(
        Integer id,
        Usuario usuario,
        Morador morador,
        BigDecimal valor,
        StatusPagamento statusPagamento,
        LocalDate localDateTime
) {
}
