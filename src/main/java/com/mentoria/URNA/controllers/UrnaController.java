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
import com.mentoria.URNA.service.VotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    private final VotoService votoService;

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
    public ResponseEntity<Eleitor> cadastrarEleitor(@RequestBody Eleitor eleitor){
        Eleitor eleitorCadastrado = eleitorService.registrar(eleitor);
        return ResponseEntity.ok(eleitorCadastrado);
    }

    @PostMapping(path = "/cadastrar-candidato")
    public ResponseEntity<Candidato> cadastrarCandidato(@RequestBody Candidato candidato){
        Candidato candidatoRegistardo = candidatoService.registrar(candidato);
        return ResponseEntity.ok(candidatoRegistardo);
    }

    @PostMapping(path = "/{ano}/votar")
    public ResponseEntity<HttpStatus> votar(@RequestBody Voto voto,
                                            @PathVariable String ano) throws Exception {
        votoService.registraVoto(voto, ano);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/resultado")
    public ResponseEntity<Map<String, Candidato>> resultado() {
        return ResponseEntity.ok(eleicaoService.resultadoDaEleicao());
    }

}
