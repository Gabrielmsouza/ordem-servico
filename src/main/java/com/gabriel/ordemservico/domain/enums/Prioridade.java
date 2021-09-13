package com.gabriel.ordemservico.domain.enums;

public enum Prioridade {
    BAIXA(0,"BAIXA"),
    MEDIA(1,"MEDIA"),
    ALTA(2,"ALTA");

    private Integer cod;
    private String descricao;

    Prioridade(Integer i, String descricao) {
        this.cod = i;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum (Integer cod){
        if (cod == null) return null;

        for (Prioridade prioridade : Prioridade.values()){
            if (cod.equals(prioridade.getCod())) {
                return prioridade;
            }
        }

        throw new IllegalArgumentException("Prioridade " + cod + " Inválida!");
    }
}
