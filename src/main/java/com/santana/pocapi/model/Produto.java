package com.santana.pocapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="PROFISSAO_ID")
    private Set<Profissao> profissoes;

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

    public Set<Profissao> getProfissoes() {
        return profissoes;
    }

    public void setProfissoes(Set<Profissao> profissoes) {
        this.profissoes = profissoes;
    }
}
