package com.mentoria.URNA.controllers;

import com.mentoria.URNA.models.entities.Candidato;
import com.mentoria.URNA.models.entities.Eleicao;
import com.mentoria.URNA.models.entities.Eleitor;
import com.mentoria.URNA.models.entities.Voto;
import com.mentoria.URNA.models.repository.CandidatoRepository;
import com.mentoria.URNA.models.repository.EleicaoRepository;
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
@RequestMapping(value = "/eleicao")
@RequiredArgsConstructor
public class UrnaController {

    private final EleitorRepository eleitorRepository;

    private final CandidatoRepository candidatoRepository;

    private final EleitorService eleitorService;

    private final CandidatoService candidatoService;

    private final EleicaoService eleicaoService;

    private final EleicaoRepository eleicaoRepository;

    @GetMapping(path = "/eleitores")
    public List<Eleitor>   listarEleitores(){
        return eleitorRepository.findAll();
    }

    @GetMapping(path = "/candidatos")
    public List<Candidato> listarCandidatos(){
        return candidatoRepository.findAll();
    }

    @PostMapping(path = "/cadastrar-eleicao")
    public ResponseEntity<HttpStatus> cadastrarEleicao(@RequestBody Eleicao eleicao){
        eleicaoRepository.save(eleicao);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping(path = "/{eleicaoId}/abrir-eleicao")
    public ResponseEntity<HttpStatus> abrirEleicao(@PathVariable Long eleicaoId){
        eleicaoService.abrirEleicao(eleicaoId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(path = "/{eleicaoId}/fechar-eleicao")
    public ResponseEntity<HttpStatus> fecharEleicao(@PathVariable Long eleicaoId){
        eleicaoService.fecharEleicao(eleicaoId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(path = "/cadastrar-eleitor")
    public ResponseEntity<HttpStatus> cadastrarEleitor(@RequestBody Eleitor eleitor){
        eleitorService.registrar(eleitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(null); // Forma errada, olhar forma padrão (grid manager)
    }

    @PostMapping(path = "/cadastrar-candidato")
    public ResponseEntity<HttpStatus> cadastrarCandidato(@RequestBody Candidato candidato){
        candidatoService.registrar(candidato);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

//    @PostMapping(path = "/{ano}/votar")
//    public ResponseEntity<HttpStatus> votar(@RequestBody Voto voto,
//                                            @PathVariable String ano){
//        eleicaoService.registrarVoto(voto, ano);
//        return ResponseEntity.ok(HttpStatus.OK);
//    }



}
