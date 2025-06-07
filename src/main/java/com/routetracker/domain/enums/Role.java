package com.routetracker.domain.enums;

public enum Role {
    ROLE_ADMIN("Administrador do sistema"),
    ROLE_MOTORISTA("Motorista");

    private final String descricao;

    Role(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getRoleNome(){
        return this.name();// Retorna "ROLE_ADMIN" ou "ROLE_MOTORISTA"
    }



}
