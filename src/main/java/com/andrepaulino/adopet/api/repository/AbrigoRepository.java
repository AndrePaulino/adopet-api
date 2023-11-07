package com.andrepaulino.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrepaulino.adopet.api.model.Abrigo;

public interface AbrigoRepository extends JpaRepository<Abrigo, Long> {
    boolean existsByNome(String nome);

    boolean existsByTelefone(String telefone);

    boolean existsByEmail(String email);

    Abrigo findByNome(String nome);
}
