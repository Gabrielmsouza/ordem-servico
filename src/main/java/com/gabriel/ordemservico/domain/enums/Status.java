package com.gabriel.ordemservico.domain.enums;

public enum Status {
    ABERTO(0,"ABERTO"),
    FECHADO(1,"FECHADO");

    private Integer cod;
    private String descricao;

    Status(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod){
        if (cod == null) return null;

        for (Status status : Status.values()){
            if (cod.equals(status.getCod())){
                return status;
            }
        }

        throw new IllegalArgumentException("Status " + cod + " Inválido!");
    }
}
