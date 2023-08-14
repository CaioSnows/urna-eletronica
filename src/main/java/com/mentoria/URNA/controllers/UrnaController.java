package com.mentoria.URNA.controllers;

import com.mentoria.URNA.models.entities.Candidato;
import com.mentoria.URNA.models.entities.Eleitor;
import com.mentoria.URNA.models.entities.Voto;
import com.mentoria.URNA.models.repository.CandidatoRepository;
import com.mentoria.URNA.models.repository.EleitorRepository;
import com.mentoria.URNA.service.CandidatoService;
import com.mentoria.URNA.service.EleicaoService;
import com.mentoria.URNA.service.EleitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/urna")
@RequiredArgsConstructor
public class UrnaController {

    private final EleitorRepository eleitorRepository;

    private final CandidatoRepository candidatoRepository;

    private final EleitorService eleitorService;

    private final CandidatoService candidatoService;

    private final EleicaoService eleicaoService;

    @GetMapping(path = "/eleitores")
    public List<Eleitor> listarEleitores(){
        return eleitorRepository.findAll();
    }

    @GetMapping(path = "/candidatos")
    public List<Candidato> listarCandidatos(){
        return candidatoRepository.findAll();
    }


    @PostMapping(path = "/cadastrar-eleitor")
    public ResponseEntity<HttpStatus> cadastrarEleitor(@RequestBody Eleitor eleitor){
        eleitorService.registrar(eleitor);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(path = "/cadastrar-candidato")
    public ResponseEntity<HttpStatus> cadastrarCandidato(@RequestBody Candidato candidato){
        candidatoService.registrar(candidato);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(path = "/votar")
    public ResponseEntity<HttpStatus> votar(@RequestBody Voto voto){
        eleicaoService.registrarVoto(voto);
        return ResponseEntity.ok(HttpStatus.OK);
    }



}
