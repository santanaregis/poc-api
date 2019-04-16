package com.santana.pocapi.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProfissaoDTO implements Serializable {

    private Long id;
    private String nome;
    private BigDecimal remuneracao;

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

    public BigDecimal getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(BigDecimal remuneracao) {
        this.remuneracao = remuneracao;
    }
}
