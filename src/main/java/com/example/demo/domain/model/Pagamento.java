package com.example.demo.domain.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name="pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    private BigDecimal valor;



    @Column(name = " data_pagamento ")
    private LocalDateTime dateDoPagamento;    // LocalDate mapeia perfeitamente para o tipo DATE do banco
}
