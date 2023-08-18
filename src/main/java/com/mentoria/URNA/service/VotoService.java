package com.mentoria.URNA.service;

import com.mentoria.URNA.exception.GovernadorNumberIsIncorrectException;
import com.mentoria.URNA.exception.PrefeitoNumberIsIncorrectException;
import com.mentoria.URNA.models.entities.Voto;
import com.mentoria.URNA.models.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    CandidatoRepository candidatoRepository;

    public void verificaCandidatos(Voto voto){

        if(voto.getNumeroDoPrefeito().length() != 2){
            throw new PrefeitoNumberIsIncorrectException();
        } else if (voto.getNumeroDoGovernador().length() != 2) {
            throw new GovernadorNumberIsIncorrectException();
        }else if (voto.getNumeroDoPresidente().length() != 2){
            throw new PrefeitoNumberIsIncorrectException();
        }
    }

    public void contabilizaVoto(Voto voto){

    }



}
