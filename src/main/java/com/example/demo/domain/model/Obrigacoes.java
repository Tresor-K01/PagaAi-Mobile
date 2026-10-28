package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name="obrigacoes")
public class Obrigacoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "despesa_id") // Nome da coluna chave estrangeira na tabela obrigacoes
    private Despesas despesas;

    @Column(name = "dat_obrigacao") // Mapeia exatamente o nome do SQL
    private LocalDate dataObrigacao;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;

    @Column(name = "valor_devido") // Mapeia exatamente o nome do SQL
    private BigDecimal valorDevido; // Renomeado para refletir o nome real da coluna

}