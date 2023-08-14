package com.mentoria.URNA.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TABELA_ELEICAO")
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpfDoEleitor;
    private String numeroDoPrefeito;

    private String numeroDoPresidente;

    private String numeroDoGovernador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfDoEleitor() {
        return cpfDoEleitor;
    }

    public void setCpfDoEleitor(String cpfDoEleitor) {
        this.cpfDoEleitor = cpfDoEleitor;
    }

    public String getNumeroDoPrefeito() {
        return numeroDoPrefeito;
    }

    public void setNumeroDoPrefeito(String numeroDoPrefeito) {
        this.numeroDoPrefeito = numeroDoPrefeito;
    }

    public String getNumeroDoGovernador() {
        return numeroDoGovernador;
    }

    public void setNumeroDoGovernador(String numeroDoGovernador) {
        this.numeroDoGovernador = numeroDoGovernador;
    }

    public String getNumeroDoPresidente() {
        return numeroDoPresidente;
    }

    public void setNumeroDoPresidente(String numeroDoPresidente) {
        this.numeroDoPresidente = numeroDoPresidente;
    }


}
