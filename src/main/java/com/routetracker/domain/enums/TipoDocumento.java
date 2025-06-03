package com.routetracker.domain.enums;

public enum TipoDocumento {
    CPF("CPF"),
    CNPJ("CNPJ"),
    CIN("CIN Cadastro Unico Nacional"),
    RNE("REN Registro Nacional de Estrangeiro");

    private final String descricao;

    TipoDocumento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
