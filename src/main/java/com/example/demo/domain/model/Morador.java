package com.example.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "morador")
public class Morador {

    @Id
    private Integer id; // ID que vem do usuário

    @OneToOne
    @MapsId // Diz que o 'id' acima é preenchido automaticamente pelo ID do objeto Usuario
    @JoinColumn(name = "id") // Aponta para a coluna 'id' na tabela morador (que referencia o usuario)
    private Usuario usuario;

    @Column(name = "numero_do_quarto")
    private String numero_do_quarto;
}