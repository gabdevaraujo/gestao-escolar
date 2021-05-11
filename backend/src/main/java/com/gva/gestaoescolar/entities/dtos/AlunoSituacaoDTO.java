package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;

import com.gva.gestaoescolar.entities.Aluno;


public class AlunoSituacaoDTO implements Serializable{

    private Long id;
    private String nome;
    private String situacao;


    public AlunoSituacaoDTO() {
    }

    public AlunoSituacaoDTO(Long id, String nome, String situacao) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
    }

    public AlunoSituacaoDTO(Aluno aluno){
        id = aluno.getId();
        nome = aluno.getNome();
        situacao = aluno.getSituacao().getSituacao();
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
