package com.example.demo.domain.repository;

import com.example.demo.domain.model.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DespesaRepository extends JpaRepository<Despesas, Integer> {
    List<Despesas> findByDataBetween(LocalDateTime dataInicio, LocalDateTime dateFim);
}
