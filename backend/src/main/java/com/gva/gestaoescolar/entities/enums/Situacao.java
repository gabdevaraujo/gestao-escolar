package com.gva.gestaoescolar.entities.enums;

public enum Situacao {

    APROVADO(1, "Aprovado"),
    REPROVADO(2, "Reprovado"),
    RECUPERACAO(3, "Recuperação");

    private int codigo;
    private String situacao;

    private Situacao(int codigo, String situacao){
        this.codigo = codigo;
        this.situacao = situacao;
    }

    public int getCodigo(){
        return codigo;
    }
    
    public String getSituacao(){
        return situacao;
    }

    public static Situacao toEnum(Integer codigo){

        if(codigo == null){
            return null;
        }

        for(Situacao s : Situacao.values()){
            if(codigo.equals(s.getCodigo())){
                return s;
            }
        }

        throw new IllegalArgumentException("Situação inválida. Código não encontrado");
    }
    
}
