package com.andrepaulino.adopet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrepaulino.adopet.api.dto.AtualizacaoTutorDto;
import com.andrepaulino.adopet.api.dto.CadastroTutorDto;
import com.andrepaulino.adopet.api.exception.ValidacaoException;
import com.andrepaulino.adopet.api.model.Tutor;
import com.andrepaulino.adopet.api.repository.TutorRepository;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutorDto dto) {
        boolean jaCadastrado = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (jaCadastrado)
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");

        repository.save(new Tutor(dto));
    }

    public void atualizar(AtualizacaoTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }

}
