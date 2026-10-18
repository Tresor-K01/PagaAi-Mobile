package com.example.demo.domain.repository;

import com.example.demo.domain.model.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends JpaRepository<Despesas, Integer> {
}
