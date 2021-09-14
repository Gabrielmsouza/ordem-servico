package com.gabriel.ordemservico.utils;

public interface Mensagem {
    static String CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado na base de Dados!";
    static String TECNICO_NAO_ENCONTRADO = "Tecnico não encontrado na base de Dados!";
    static String OS_NAO_ENCONTRADO = "Ordem de Serviço não encontrada na base de Dados!";

    public static String CPF_JA_CADASTRADO(String cpf){
        return "CPF " + cpf + " já cadastrado na base de Dados!";
    }
}
