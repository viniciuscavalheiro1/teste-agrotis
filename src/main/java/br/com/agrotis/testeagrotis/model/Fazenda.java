package br.com.agrotis.testeagrotis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "fazenda")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fazenda")
    private Long id;

    @Column(name = "data_inicial")
    private Date data_inicial;

    @Column(name = "data_final")
    private Date data_final;

    @Column(name = "id_propriedade_fazenda")
    private Long id_propriedade_fazenda;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "id_laboratorio")
    private Long id_laboratorio;

    @Column(name = "observacoes")
    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
