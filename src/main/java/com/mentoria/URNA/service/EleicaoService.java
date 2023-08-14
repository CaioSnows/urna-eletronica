package com.mentoria.URNA.service;

import com.mentoria.URNA.exception.EleitorAlreadyVotedExeception;
import com.mentoria.URNA.models.entities.Voto;
import com.mentoria.URNA.models.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EleicaoService {

    @Autowired
    VotoRepository votoRepository;

    public void registrarVoto(Voto voto){

        verificaVoto(voto);
        votoRepository.save(voto);
    }

    public void verificaVoto(Voto voto){
        List<Voto> listaVoto = votoRepository.findAll();

        List<String> listCpfEleitor = new ArrayList<>();
        listaVoto.forEach(voto1 -> listCpfEleitor.add(
                voto1.getCpfDoEleitor()));

        boolean validacao = listCpfEleitor.contains(voto.getCpfDoEleitor());
        if(validacao){
            throw new EleitorAlreadyVotedExeception();
        }
    }
}
