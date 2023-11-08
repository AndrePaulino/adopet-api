package com.andrepaulino.adopet.api.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andrepaulino.adopet.api.dto.SolicitacaoAdocaoDto;
import com.andrepaulino.adopet.api.exception.ValidacaoException;
import com.andrepaulino.adopet.api.model.Pet;
import com.andrepaulino.adopet.api.repository.PetRepository;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private PetRepository petRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }

}
