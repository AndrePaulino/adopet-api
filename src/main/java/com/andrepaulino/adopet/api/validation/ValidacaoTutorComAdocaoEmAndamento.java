package com.andrepaulino.adopet.api.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andrepaulino.adopet.api.dto.SolicitacaoAdocaoDto;
import com.andrepaulino.adopet.api.exception.ValidacaoException;
import com.andrepaulino.adopet.api.model.Adocao;
import com.andrepaulino.adopet.api.model.StatusAdocao;
import com.andrepaulino.adopet.api.model.Tutor;
import com.andrepaulino.adopet.api.repository.AdocaoRepository;
import com.andrepaulino.adopet.api.repository.TutorRepository;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public void validar(SolicitacaoAdocaoDto dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }

}
