package com.gva.gestaoescolar.entities.enums;

public enum TipoAv {

    PARTICIPACAO_SALA_AULA(1, "Paricipação em Sala de Aula"),
    ENTREGA_TAREFAS(2, "Entrega de Tarefas"),
    TRABALHO_BIMESTRAL(3, "Trabalhos Bimestrais"),
    PROVA_BIMESTRAL(4, "Prova Bimestral");

    private int codigo;
    private String tipoAv;

    private TipoAv(int codigo, String tipoAv){
        this.codigo = codigo;
        this.tipoAv = tipoAv;
    }

    public int getCodigo(){
        return codigo;
    }

    public String getTipoAv(){
        return tipoAv;
    }

    public static TipoAv toEnum(Integer codigo){
        if(codigo == null){
            return null;
        }

        for(TipoAv x : TipoAv.values()){
            if(codigo.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }
}
