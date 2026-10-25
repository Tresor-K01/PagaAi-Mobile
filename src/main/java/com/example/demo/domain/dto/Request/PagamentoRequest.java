package com.example.demo.domain.dto.Request;

import com.example.demo.domain.model.Morador;
import com.example.demo.domain.model.Usuario;
import com.example.demo.domain.model.enums.StatusPagamento;

import java.math.BigDecimal;

public record PagamentoRequest(
        BigDecimal valor,
        Morador morador,
        StatusPagamento statusPagamento
) {
}
