package br.com.agrotis.testeagrotis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratorio")
public class Laboratorio {
    @Id
    @Column(name = "id_laboratorio")
    private Long id;
    @Column(name = "nome_laboratorio")
    private String nome;

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
