package com.mentoria.URNA.controllers;

import com.mentoria.URNA.models.entities.Candidato;
import com.mentoria.URNA.models.entities.Eleitor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/urna")
public class UrnaController {


    @PostMapping(path = "/cadastrar-eleitor")
    public ResponseEntity<HttpStatus> cadastrarEleitor(@RequestBody Eleitor eleitor){
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping(path = "/cadastrar-candidato")
    public ResponseEntity<HttpStatus> cadastrarCandidato(@RequestBody Candidato candidato){
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
