package br.com.agrotis.testeagrotis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "infos_propriedade")
public class InfoPropriedade {
    @Id
    @Column(name = "id_propriedade")
    private Long id;
    @Column(name = "nome_propriedade")
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
