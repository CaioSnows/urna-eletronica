package com.mentoria.URNA.service;

import com.mentoria.URNA.exception.*;
import com.mentoria.URNA.models.entities.Candidato;
import com.mentoria.URNA.models.entities.Eleicao;
import com.mentoria.URNA.models.entities.Eleitor;
import com.mentoria.URNA.models.entities.Voto;
import com.mentoria.URNA.models.repository.CandidatoRepository;
import com.mentoria.URNA.models.repository.EleicaoRepository;
import com.mentoria.URNA.models.repository.EleitorRepository;
import com.mentoria.URNA.models.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VotoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    @Autowired
    EleitorRepository eleitorRepository;

    @Autowired
    VotoRepository votoRepository;

    @Autowired
    EleicaoRepository eleicaoRepository;

    public void registraVoto(Voto voto, String ano) throws Exception {

        verificaRegistroDoEleitor(voto);
        verificaNumeroDosCandidatos(voto);
        verificarEleicaoEstaAberta(ano);

        List<Candidato> candidatos = candidatoRepository.findAll();

        Candidato prefeito = candidatos.stream()
                .filter( candidato -> candidato.getNumeroDoCandidato()
                .equals(voto.getNumeroDoPrefeito()))
                .findFirst()
                .orElseThrow(() -> new EntityDoesNotExistException("prefeito"));

        Candidato governador = candidatos.stream()
                .filter(candidato -> candidato.getNumeroDoCandidato()
                .equals(voto.getNumeroDoGovernador()))
                .findFirst()
                .orElseThrow(() -> new EntityDoesNotExistException("governador"));

        Candidato presidente = candidatos.stream()
                .filter(candidato -> candidato.getNumeroDoCandidato()
                .equals(voto.getNumeroDoPresidente()))
                .findFirst()
                .orElseThrow(() -> new EntityDoesNotExistException("presidente"));

        prefeito.setNumeroDeVotos(prefeito.getNumeroDeVotos() + 1);
        governador.setNumeroDeVotos(governador.getNumeroDeVotos() + 1);
        presidente.setNumeroDeVotos(presidente.getNumeroDeVotos() + 1);
        candidatoRepository.save(prefeito);
        candidatoRepository.save(governador);
        candidatoRepository.save(presidente);

        votoRepository.save(voto);
    }

    public void verificaNumeroDosCandidatos(Voto voto){

        if(voto.getNumeroDoPrefeito().length() != 2){
            throw new PrefeitoNumberIsIncorrectException();
        } else if (voto.getNumeroDoGovernador().length() != 2) {
            throw new GovernadorNumberIsIncorrectException();
        }else if (voto.getNumeroDoPresidente().length() != 2){
            throw new PrefeitoNumberIsIncorrectException();
        }
    }

    public void verificaRegistroDoEleitor(Voto voto){

        List<Eleitor> eleitores = eleitorRepository.findAll();

        List<String> listaCpf = new ArrayList<>();
        eleitores.forEach(eleitor -> listaCpf.add(eleitor.getCpf()));

        boolean validacao = listaCpf.contains(voto.getCpfDoEleitor());
        if (!validacao){
            throw new CpfIsIncorrectException();
        }
    }

    public void verificarEleicaoEstaAberta(String ano) throws Exception {

        Eleicao eleicao = eleicaoRepository.findByAno(ano);
        if(!eleicao.isActive()){
            throw new Exception("Eleição está fechada");
        }
    }
}
