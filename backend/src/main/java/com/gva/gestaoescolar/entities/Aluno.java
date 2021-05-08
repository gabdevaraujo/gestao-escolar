package com.gva.gestaoescolar.entities;

import java.util.List;

import com.gva.gestaoescolar.entities.enums.Situacao;

public class Aluno {

    private Long id;
    private String nome;
    private Situacao situacao;
    private List<Bimestre> bimestres;


    public Aluno() {
    }

    public Aluno(Long id, String nome, Situacao situacao, List<Bimestre> bimestres) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
        this.bimestres = bimestres;
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

    public Situacao getSituacao() {
        return this.situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public List<Bimestre> getBimestres() {
        return this.bimestres;
    }
    
}
