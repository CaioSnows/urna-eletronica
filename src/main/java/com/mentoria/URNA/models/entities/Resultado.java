package com.mentoria.URNA.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TABELA_RESULTADO")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String anoDaEleicao;
    private String prefeitoEleito;
    private String governadorEleito;
    private String presidenteEleito;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnoDaEleicao() {
        return anoDaEleicao;
    }

    public void setAnoDaEleicao(String anoDaEleicao) {
        this.anoDaEleicao = anoDaEleicao;
    }

    public String getPrefeitoEleito() {
        return prefeitoEleito;
    }

    public void setPrefeitoEleito(String prefeitoEleito) {
        this.prefeitoEleito = prefeitoEleito;
    }

    public String getGovernadorEleito() {
        return governadorEleito;
    }

    public void setGovernadorEleito(String governadorEleito) {
        this.governadorEleito = governadorEleito;
    }

    public String getPresidenteEleito() {
        return presidenteEleito;
    }

    public void setPresidenteEleito(String presidenteEleito) {
        this.presidenteEleito = presidenteEleito;
    }

}
