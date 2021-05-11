package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Falta;
import com.gva.gestaoescolar.entities.enums.Situacao;

public class AlunoDTO implements Serializable{

    private Long id;
    private String nome;
    private Integer situacao;

    private Integer totalFaltas;


    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String nome, List<Falta> faltas, Situacao situacao) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao.getCodigo();
    }

    public AlunoDTO(Aluno aluno){
        id = aluno.getId();
        nome = aluno.getNome();
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
        return Situacao.toEnum(situacao);
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao.getCodigo();
    }
}
