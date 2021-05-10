package com.gva.gestaoescolar.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gva.gestaoescolar.entities.enums.Situacao;

@Entity
@Table(name = "tb_aluno")
public class Aluno implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer situacao;

    @OneToMany(mappedBy = "aluno")
    private List<Avaliacao> avs = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    private List<Falta> faltas = new ArrayList<>();


    public Aluno() {
    }

    public Aluno(Long id, String nome, Situacao situacao, List<Avaliacao> avs, List<Falta> faltas) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao.getCodigo();
        this.avs = avs;
        this.faltas = faltas;
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

    public List<Avaliacao> getAvs() {
        return this.avs;
    }

    public void setAvs(List<Avaliacao> avs) {
        this.avs = avs;
    }

    public List<Falta> getFaltas() {
        return this.faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

    public int getTotalFaltas(){
        int totalFaltas = 0;
        for(Falta f : faltas){
            totalFaltas += f.getQtd();
        }
        return totalFaltas;
    }

}
