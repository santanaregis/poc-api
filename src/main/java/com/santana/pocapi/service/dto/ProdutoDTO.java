package com.santana.pocapi.service.dto;

import com.santana.pocapi.model.Profissao;

import java.io.Serializable;
import java.util.Set;

public class ProdutoDTO implements Serializable {

    private Long id;
    private String nome;
    private Set<ProfissaoDTO> profissoes;

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

    public Set<ProfissaoDTO> getProfissoes() {
        return profissoes;
    }

    public void setProfissoes(Set<ProfissaoDTO> profissoes) {
        this.profissoes = profissoes;
    }
}
