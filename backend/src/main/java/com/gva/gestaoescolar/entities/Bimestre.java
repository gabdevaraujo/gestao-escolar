package com.gva.gestaoescolar.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class Bimestre {
    
    public final Integer DIAS = 40;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer faltas;


    private List<Aluno> alunos;

    private List<Avaliacao> avs;


    public Bimestre() {
    }


    public Bimestre(Long id, Integer faltas, List<Aluno> alunos, List<Avaliacao> avs) {
        this.id = id;
        this.faltas = faltas;
        this.alunos = alunos;
        this.avs = avs;
    }

    public Integer getDIAS() {
        return this.DIAS;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFaltas() {
        return this.faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public List<Aluno> getAlunos() {
        return this.alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Avaliacao> getAvs() {
        return this.avs;
    }

    public void setAvs(List<Avaliacao> avs) {
        this.avs = avs;
    }

}
