package br.com.agrotis.testeagrotis.controller.dto;


import br.com.agrotis.testeagrotis.model.InfoPropriedade;

public class InfoPropriedadeRs {
    private Long id;
    private String nome;

    public static InfoPropriedadeRs converter(InfoPropriedade iF) {
        var infoPropriedade = new InfoPropriedadeRs();
        infoPropriedade.setId(iF.getId());
        infoPropriedade.setNome(iF.getNome());
        return infoPropriedade;
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
