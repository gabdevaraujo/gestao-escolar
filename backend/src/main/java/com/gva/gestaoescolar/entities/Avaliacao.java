package com.gva.gestaoescolar.entities;

public class Avaliacao {

    private Long id;
    private String nome;
    private Double peso;

    private Bimestre bimestre;


    public Avaliacao() {
    }

    public Avaliacao(Long id, String nome, Double peso, Bimestre bimestre) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.bimestre = bimestre;
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

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Bimestre getBimestre() {
        return this.bimestre;
    }

    public void setBimestre(Bimestre bimestre) {
        this.bimestre = bimestre;
    }

    
}
