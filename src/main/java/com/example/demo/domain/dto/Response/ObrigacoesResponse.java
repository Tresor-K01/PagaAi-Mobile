package com.example.demo.domain.dto.Response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ObrigacoesResponse(
        Integer id,
        LocalDate dataObrigacao,
        LocalDate dataVencimento,
        BigDecimal valorDevido
) {
}
