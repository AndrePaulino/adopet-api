package com.andrepaulino.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrepaulino.adopet.api.model.Adocao;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

}
