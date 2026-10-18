package com.example.demo.domain.model;


import com.example.demo.domain.model.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;


    @ManyToOne
    @JoinColumn(name = "id_morador")
    private Morador morador;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @Column(name = "data_pagamento")
    private LocalDate dateDoPagamento;    // LocalDate mapeia perfeitamente para o tipo DATE do banco
}
