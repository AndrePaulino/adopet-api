package com.andrepaulino.adopet.api.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andrepaulino.adopet.api.dto.SolicitacaoAdocaoDto;
import com.andrepaulino.adopet.api.exception.ValidacaoException;
import com.andrepaulino.adopet.api.model.Adocao;
import com.andrepaulino.adopet.api.model.Pet;
import com.andrepaulino.adopet.api.model.StatusAdocao;
import com.andrepaulino.adopet.api.repository.AdocaoRepository;
import com.andrepaulino.adopet.api.repository.PetRepository;

@Component
public class ValidacaoPetComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private PetRepository petRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();
        Pet pet = petRepository.getReferenceById(dto.idPet());
        for (Adocao a : adocoes) {
            if (a.getPet() == pet && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");

            }
        }
    }

}
