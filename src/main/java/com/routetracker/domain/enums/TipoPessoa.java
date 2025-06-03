package com.routetracker.domain.enums;

public enum TipoPessoa {
    ADMIN("Admin"),
    MOTORISTA("Motorista");

    private final String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
