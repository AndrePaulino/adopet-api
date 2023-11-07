package com.andrepaulino.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrepaulino.adopet.api.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
