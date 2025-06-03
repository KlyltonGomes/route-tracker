package com.routetracker.domain.enums;

public enum StatusLocalizacao {
    EM_ROTA("Em Rota"),
    PARADO("Parado"),
    FORA_ROTA("Fora da rota prevista"),
    CHEGADA_CONFIRMADA("Chegada ao destino confirmada"),
    COLETA_CONFIRMADA("Coleta confirmada no ponto de origem"),
    AGUARDANDO_PROXIMA_ROTA("Aguardando início da próxima rota"),
    ROTA_FINALIZADA("Rota finalizada com sucesso");

    private final String descricao;

    StatusLocalizacao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
