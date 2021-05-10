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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "tb_bimestre")
public class Bimestre implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "bimestre")
    private List<Avaliacao> avs = new ArrayList<>();

    
    @OneToMany(mappedBy = "bimestre")
    private List<Falta> faltas = new ArrayList<>();

    public Bimestre() {
    }  

    public Bimestre(Long id, String nome, List<Avaliacao> avs, List<Falta> faltas) {
        this.id = id;
        this.nome = nome;
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

}
