package com.example.demo.domain.dto.Request;

import com.example.demo.domain.dto.Response.TotalDespesasResponse;
import com.example.demo.domain.model.enums.StatusPagamento;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ObrigacoesRequest(
        @NotNull(message = "Campo obrigatorio")
        Integer despesasId
) {
}
