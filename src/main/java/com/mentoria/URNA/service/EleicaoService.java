package com.mentoria.URNA.service;

import com.mentoria.URNA.exception.EleicaoDoesNotExistsException;
import com.mentoria.URNA.models.entities.Eleicao;
import com.mentoria.URNA.models.repository.EleicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EleicaoService {

    @Autowired
    EleicaoRepository eleicaoRepository;

    public void abrirEleicao(Long id){
        Eleicao eleicao = eleicaoRepository.findById(id)
                .orElseThrow(EleicaoDoesNotExistsException::new);

        eleicao.setActive(true);
        eleicaoRepository.save(eleicao);
    }

    public void fecharEleicao(Long id){
        Eleicao eleicao = eleicaoRepository.findById(id)
                .orElseThrow(EleicaoDoesNotExistsException::new);

        eleicao.setActive(false);
        eleicaoRepository.save(eleicao);
    }
}
