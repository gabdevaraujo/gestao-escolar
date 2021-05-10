package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;

import com.gva.gestaoescolar.entities.Aluno;
import com.gva.gestaoescolar.entities.Avaliacao;
import com.gva.gestaoescolar.entities.Bimestre;
import com.gva.gestaoescolar.entities.enums.TipoAv;

public class AvaliacaoPorAlunoDTO implements Serializable{

    private Long id;
    private String tipoAv;
    private Double peso;
    private Long bimestreId;

    public AvaliacaoPorAlunoDTO() {

    }

    public AvaliacaoPorAlunoDTO(Long id, String tipoAv, Double peso, Long bimestreId) {
        this.id = id;
        this.tipoAv = tipoAv;
        this.peso = peso;
        this.bimestreId = bimestreId;
    }

    public AvaliacaoPorAlunoDTO(Avaliacao av){
            id = av.getId();
            tipoAv = av.getTipoAv().getTipoAv();
            peso = av.getPeso();
            bimestreId =av.getBimestre().getId();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoAv() {
        return this.tipoAv;
    }

    public void setTipoAv(String tipoAv) {
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


    }
