package com.mentoria.URNA.service;

import com.mentoria.URNA.exception.EleicaoDoesNotExistsException;
import com.mentoria.URNA.models.entities.Candidato;
import com.mentoria.URNA.models.entities.Eleicao;
import com.mentoria.URNA.models.repository.CandidatoRepository;
import com.mentoria.URNA.models.repository.EleicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EleicaoService {

    @Autowired
    EleicaoRepository eleicaoRepository;

    @Autowired
    CandidatoRepository candidatoRepository;

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

    public Map<String, Candidato> resultadoDaEleicao() {
        List<String> cargos = Arrays.asList("Prefeito", "Governador", "Presidente");
        Map<String, Candidato> candidatosMaisVotados = new HashMap<>();

        for (String cargo : cargos) {
            Candidato candidato = candidatoRepository.findTopByCargoOrderByNumeroDeVotosDesc(cargo);
            candidatosMaisVotados.put(cargo, candidato);
        }
        return candidatosMaisVotados;
    }
}
