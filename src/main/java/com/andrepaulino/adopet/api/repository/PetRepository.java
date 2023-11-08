package com.andrepaulino.adopet.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrepaulino.adopet.api.model.Abrigo;
import com.andrepaulino.adopet.api.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByAdotadoFalse();

    List<Pet> findByAbrigo(Abrigo abrigo);
}
