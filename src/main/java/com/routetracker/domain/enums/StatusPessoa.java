package com.routetracker.domain.enums;

public enum StatusPessoa {
    ATIVO("Ativo"),
    AGUARDANDO_APROVACAO("Aguardando Aprovação"),
    SUSPENSO("Suspenso"),
    BLOQUEADO("Bloqueado");

    private final String descricao;

    StatusPessoa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
