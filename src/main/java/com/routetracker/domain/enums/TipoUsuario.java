package com.routetracker.domain.enums;

public enum TipoUsuario {
    ADMIN("Admin"),
    MOTORISTA("Motorista");

    private final String descricao;

    TipoUsuario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
