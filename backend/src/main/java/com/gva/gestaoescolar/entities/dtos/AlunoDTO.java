package com.gva.gestaoescolar.entities.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gva.gestaoescolar.entities.Falta;
import com.gva.gestaoescolar.entities.enums.Situacao;

public class AlunoDTO implements Serializable{

    private Long id;
    private String nome;
    private Integer situacao;

    private List<AvaliacaoRegisterDTO> avs = new ArrayList<>();

    private List<Falta> faltas = new ArrayList<>();


    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String nome, Situacao situacao, List<AvaliacaoRegisterDTO> avs, List<Falta> faltas) {
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

    public List<AvaliacaoRegisterDTO> getAvs() {
        return this.avs;
    }

    public void setAvs(List<AvaliacaoRegisterDTO> avs) {
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
