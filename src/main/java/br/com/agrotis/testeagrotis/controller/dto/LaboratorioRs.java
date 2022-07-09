package br.com.agrotis.testeagrotis.controller.dto;

import br.com.agrotis.testeagrotis.model.Laboratorio;

public class LaboratorioRs {
    private Long id;
    private String nome;

    public static LaboratorioRs converter(Laboratorio l) {
        var laboratorio = new LaboratorioRs();
        laboratorio.setId(l.getId());
        laboratorio.setNome(l.getNome());
        return laboratorio;
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
