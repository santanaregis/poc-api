package com.santana.pocapi.service.dto;

import java.io.Serializable;
import java.util.Set;

public class PessoaDTO implements Serializable {

    private Long id;
    public String nome;
    public String cpf;
    public ProfissaoDTO profissao;
    private Set<EnderecoDTO> enderecos;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ProfissaoDTO getProfissao() {
        return profissao;
    }

    public void setProfissao(ProfissaoDTO profissao) {
        this.profissao = profissao;
    }

    public Set<EnderecoDTO> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Set<EnderecoDTO> enderecos) {
        this.enderecos = enderecos;
    }
}
