package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;

import com.gva.gestaoescolar.entities.Avaliacao;


public class AvaliacaoRegisterDTO implements Serializable{

    private Long id;
    private Integer tipoAv;
    private Double peso;
    private Long bimestreId;
    private Long alunoId;

    public AvaliacaoRegisterDTO() {
    }


    public AvaliacaoRegisterDTO(Long id, Integer tipoAv, Double peso, Long bimestreId, Long alunoId) {
        this.id = id;
        this.tipoAv = tipoAv;
        this.peso = peso;
        this.bimestreId = bimestreId;
        this.alunoId = alunoId;
    }
    
    public AvaliacaoRegisterDTO(Avaliacao av){
        id = av.getId();
        tipoAv = av.getTipoAv().getCodigo();
        peso = av.getPeso();
        bimestreId = av.getBimestre().getId();
        alunoId = av.getAluno().getId();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
