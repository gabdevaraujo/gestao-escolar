package com.gva.gestaoescolar.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.gva.gestaoescolar.entities.enums.TipoAv;

@Entity
@Table(name = "tb_avs")
public class Avaliacao implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tipoAv;
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "id_bimestre")
    private Bimestre bimestre;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    public Avaliacao() {
    }

    public Avaliacao(Long id, TipoAv tipoAv, Double peso, Bimestre bimestre, Aluno aluno) {
        this.id = id;
        this.tipoAv = tipoAv.getCodigo();
        this.peso = peso;
        this.bimestre = bimestre;
        this.aluno = aluno;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoAv getTipoAv() {
        return TipoAv.toEnum(tipoAv);
    }

    public void setTipoAv(TipoAv tipoAv) {
        this.tipoAv = tipoAv.getCodigo();
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

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
        
}
