package com.andrepaulino.adopet.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrepaulino.adopet.api.model.Pet;
import com.andrepaulino.adopet.api.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository repository;

    @GetMapping
    public ResponseEntity<List<Pet>> listarTodosDisponiveis() {
        List<Pet> pets = repository.findAll();
        List<Pet> disponiveis = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getAdotado() == false) {
                disponiveis.add(pet);
            }
        }
        return ResponseEntity.ok(disponiveis);
    }

}
