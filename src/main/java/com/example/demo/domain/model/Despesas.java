package com.example.demo.domain.model;

import com.example.demo.domain.model.enums.CategoriaDespesa;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name="despesas")
public class Despesas {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")  // Mapeia o Enum para a coluna 'tipo' do SQL
    private CategoriaDespesa categoriaDespesa;

    @Column(name = "data")// Mapeia o Enum para a coluna 'tipo' do SQL
    private LocalDateTime data; // LocalDate mapeia perfeitamente para o tipo DATE do banco

    private BigDecimal valor;

}
