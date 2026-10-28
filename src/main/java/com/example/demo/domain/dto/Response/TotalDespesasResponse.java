package com.example.demo.domain.dto.Response;

import java.math.BigDecimal;
import java.util.List;

public record TotalDespesasResponse(
        List<ObrigacoesResponse> obrigacoesResponses,
        BigDecimal totalDespesas
) {
}
