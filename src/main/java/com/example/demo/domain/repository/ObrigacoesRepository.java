package com.example.demo.domain.repository;

import com.example.demo.domain.model.Obrigacoes;
import com.example.demo.domain.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObrigacoesRepository extends JpaRepository<Obrigacoes, Integer> {
}
