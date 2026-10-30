package com.example.demo.domain.repository;

import com.example.demo.domain.model.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Integer> {
    // Procura por partes do nome, ignorando maiúsculas e minúsculas

    List<Morador> findByUsuarioNomeContainingIgnoreCase(String nome);
}
