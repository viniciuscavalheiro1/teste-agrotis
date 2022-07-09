package br.com.agrotis.testeagrotis.controller.dto;

import javax.persistence.Column;
import java.util.Date;

public class FazendaRq {
    private Date data_inicial;
    private Date data_final;
    private Long id_propriedade_fazenda;
    private String cnpj;
    private Long id_laboratorio;
    private String observacoes;

    public FazendaRq(Date data_inicial, Date data_final, Long id_propriedade_fazenda, String cnpj, Long id_laboratorio, String observacoes) {
        this.data_inicial = data_inicial;
        this.data_final = data_final;
        this.id_propriedade_fazenda = id_propriedade_fazenda;
        this.cnpj = cnpj;
        this.id_laboratorio = id_laboratorio;
        this.observacoes = observacoes;
    }

    public Date getData_inicial() {
        return data_inicial;
    }

    public void setData_inicial(Date data_inicial) {
        this.data_inicial = data_inicial;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public Long getId_propriedade_fazenda() {
        return id_propriedade_fazenda;
    }

    public void setId_propriedade_fazenda(Long id_propriedade_fazenda) {
        this.id_propriedade_fazenda = id_propriedade_fazenda;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(Long id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
