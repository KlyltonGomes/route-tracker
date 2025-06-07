package com.routetracker.domain.enums;

public enum StatusConvite {

    ENVIADO("Convite Enviado"),
    ACEITO("Convite Aceito"),
    EXPIRADO("Convite Expirado"),
    CANCELADO("Convite Cancelado");

    private final String descricao;

    StatusConvite(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
