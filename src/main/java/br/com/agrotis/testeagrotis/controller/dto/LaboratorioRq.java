package br.com.agrotis.testeagrotis.controller.dto;

import javax.persistence.Column;
import javax.persistence.Id;

public class LaboratorioRq {
    private Long id;
    private String nome;

    public LaboratorioRq(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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
}
