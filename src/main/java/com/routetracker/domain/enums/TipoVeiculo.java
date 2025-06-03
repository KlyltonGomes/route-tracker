package com.routetracker.domain.enums;

public enum TipoVeiculo {

    MOTO("Moto"),
    CARRO("Carro"),
    Caminhao("Caminhao"),
    BICICLETA("Bicicleta");

    private final String descricao;

    TipoVeiculo(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
