package com.routetracker.domain.enums;

public enum StatusEntrega {
    AGUARDANDO_COLETA("Aguardando coleta"),
    EM_TRANSITO("Em trânsito"),
    ENTREGUE("Entregue"),
    INSUCESSO("Entrega não realizada"),
    CANCELADA("Entrega cancelada"),
    FINALIZADA("Entrega finalizada com sucesso");

    private final String descricao;

    StatusEntrega(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
