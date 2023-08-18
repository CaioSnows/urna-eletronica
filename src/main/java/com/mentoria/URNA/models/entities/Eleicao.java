package com.mentoria.URNA.models.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TABELA_ELEICAO")
public class Eleicao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ano;
    private boolean active;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    private String resultado;
}
