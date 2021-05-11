package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.entities.enums.TipoAv;

public class AvaliacaoRegisterDTO implements Serializable{

    private Integer tipoAv;
    private Double peso;
    private Bimestre bimestre;
    private Aluno aluno;

    public AvaliacaoRegisterDTO() {
    }

    public AvaliacaoRegisterDTO(TipoAv tipoAv, Double peso, Aluno aluno, Bimestre bimestre) {
        this.tipoAv = tipoAv.getCodigo();
        this.peso = peso;
        this.aluno = aluno;
        this.bimestre = bimestre;
    }

    public AvaliacaoRegisterDTO (Avaliacao av){
        
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
