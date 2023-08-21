package com.mentoria.URNA.service;

import br.com.caelum.stella.validation.CPFValidator;
import com.mentoria.URNA.exception.CandidatoAlreadyRegisterException;
import com.mentoria.URNA.exception.CpfIsIncorrectException;
import com.mentoria.URNA.exception.EleitorAlreadyRegisterException;
import com.mentoria.URNA.models.entities.Candidato;
import com.mentoria.URNA.models.entities.Eleitor;
import com.mentoria.URNA.models.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    CandidatoRepository candidatoRepository;

    public Candidato registrar(Candidato candidato){
        verificaRegistro(candidato);
        validaCpf(candidato);

        candidatoRepository.save(candidato);
        return candidato;
    }

    public void verificaRegistro(Candidato candidato){
        List<Candidato> listaCandidato = candidatoRepository.findAll();

        List<String> listaCpf = new ArrayList<>();
        listaCandidato.forEach(candidato1 -> listaCpf.add(candidato1.getCpf()));

        boolean validacao = listaCpf.contains(candidato.getCpf());
        if (validacao){
            throw new CandidatoAlreadyRegisterException();
        }

        List<String> listaNumero = new ArrayList<>();
        listaCandidato.forEach(candidato1 -> listaNumero.add(candidato1.getNumeroDoCandidato()));

        boolean validacaoNumero = listaNumero.contains(candidato.getNumeroDoCandidato());
        if (validacaoNumero){
            throw new CandidatoAlreadyRegisterException();
        }



    }

    public void validaCpf(Candidato candidato) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(candidato.getCpf());
        } catch (Exception e) {
            throw new CpfIsIncorrectException();
        }
    }
}
