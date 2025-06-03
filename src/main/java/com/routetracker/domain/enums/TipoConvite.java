package com.routetracker.domain.enums;

public enum TipoConvite {

    ENVIADO("Convite Enviado"),
    ACEITO("Convite Aceito"),
    EXPIRADO("Convite Expirado"),
    CANCELADO("Convite Cancelado");

    private final String descricao;

    TipoConvite(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
