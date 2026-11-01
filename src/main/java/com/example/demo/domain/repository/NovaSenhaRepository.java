package com.example.demo.domain.repository;

import com.example.demo.domain.model.NovaSenha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NovaSenhaRepository extends JpaRepository<NovaSenha, Integer> {

    Optional<NovaSenha> findByUsuario_Email(String email);
    Optional<NovaSenha>findByToken(String token);
}
