package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.entities.Falta;

public class FaltasDTO implements Serializable{

    private Long id;
    private Integer qtd;
    private Long bimestreId;
    private Long alunoId;


    public FaltasDTO() {
    }


    public FaltasDTO(Long id, Integer qtd, Long bimestreId, Long alunoId) {
        this.id = id;
        this.qtd = qtd;
        this.bimestreId = bimestreId;
        this.alunoId = alunoId;
    }

    public FaltasDTO(Falta falta){
        id = falta.getId();
        qtd = falta.getQtd();
        bimestreId = falta.getBimestre().getId();
        alunoId = falta.getAluno().getId();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtd() {
        return this.qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
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
