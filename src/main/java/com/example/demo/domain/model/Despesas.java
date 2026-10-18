package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="despesa")
public class Despesas {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipo;

    private LocalDateTime data;

    private BigDecimal valor;

}
