package com.mentoria.URNA.service;


import br.com.caelum.stella.validation.CPFValidator;
import com.mentoria.URNA.exception.CpfIsIncorrectException;
import com.mentoria.URNA.exception.EleitorAlreadyRegisterException;
import com.mentoria.URNA.models.entities.Eleitor;
import com.mentoria.URNA.models.repository.EleitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EleitorService {

    @Autowired
    private EleitorRepository eleitorRepository;

    public void registrar(Eleitor eleitor){
        verificaCpf(eleitor);
        validaCpf(eleitor);

        eleitorRepository.save(eleitor);
    }

    public void verificaCpf(Eleitor eleitor){
        List<Eleitor> listaUsuario = eleitorRepository.findAll();

        List<String> listaCpf = new ArrayList<>();
        listaUsuario.forEach(usuario1 -> listaCpf.add(usuario1.getCpf()));

        boolean validacao = listaCpf.contains(eleitor.getCpf());
        if (validacao){
            throw new EleitorAlreadyRegisterException();
        }
    }

    public void validaCpf(Eleitor eleitor) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(eleitor.getCpf());
        } catch (Exception e) {
            throw new CpfIsIncorrectException();
        }
    }
}
