package com.routetracker.domain.enums;

public enum StatusUsuario {
    ATIVO("Ativo"),
    PENDENTE("Pendente"),
    SUSPENSO("Suspenso"),
    BLOQUEADO("Bloqueado");

    private final String descricao;

    StatusUsuario(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
