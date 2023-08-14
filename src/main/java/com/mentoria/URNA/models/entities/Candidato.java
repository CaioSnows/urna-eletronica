package com.mentoria.URNA.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TABELA_CANDIDATO")
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String partido;
    private String numeroDoCandidato;
    private String cargo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getNumeroDoCandidato() {
        return numeroDoCandidato;
    }

    public void setNumeroDoCandidato(String numeroDoCandidato) {
        this.numeroDoCandidato = numeroDoCandidato;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    }
