package com.gva.gestaoescolar.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gva.gestaoescolar.entities.dtos.FaltasDTO;

@Entity
@Table(name = "tb_faltas")
public class Falta implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer qtd;

    @ManyToOne
    @JoinColumn(name = "id_bimestre")
    private Bimestre bimestre;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    public Falta() {
    }

    public Falta(Integer qtd, Bimestre bimestre) {
        this.qtd = qtd;
        this.bimestre = bimestre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


    public Bimestre getBimestre() {
        return bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    public Integer getQtd() {
        return this.qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
    
}
