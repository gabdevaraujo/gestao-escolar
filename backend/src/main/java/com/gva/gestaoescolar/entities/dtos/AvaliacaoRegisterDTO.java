package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.entities.enums.TipoAv;

public class AvaliacaoRegisterDTO implements Serializable{

    private Integer tipoAv;
    private Double peso;
    private Long bimestreId;
    private Long alunoId;

    public AvaliacaoRegisterDTO() {
    }


    public AvaliacaoRegisterDTO(Integer tipoAv, Double peso, Long bimestreId, Long alunoId) {
        this.tipoAv = tipoAv;
        this.peso = peso;
        this.bimestreId = bimestreId;
        this.alunoId = alunoId;
    }
    
    public AvaliacaoRegisterDTO(Avaliacao av){
        tipoAv = av.getTipoAv().getCodigo();
        peso = av.getPeso();
        bimestreId = av.getBimestre().getId();
        alunoId = av.getAluno().getId();
    }

    public Integer getTipoAv() {
        return this.tipoAv;
    }

    public void setTipoAv(Integer tipoAv) {
        this.tipoAv = tipoAv;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Long getBimestreId() {
        return this.bimestreId;
    }

    public void setBimestreId(Long bimestreId) {
        this.bimestreId = bimestreId;
    }

    public Long getAlunoId() {
        return this.alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }
        
}
