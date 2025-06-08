package com.routetracker.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Parada")
@SequenceGenerator(name = "seq_Parada", sequenceName = "seq_Parada", allocationSize = 1, initialValue = 1)
public class Parada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Parada")
    private Long id;

    private String cep;

    private String numero; // número da casa / local

    private Integer duracaoEstimada; // em minutos

    private Boolean entregaRealizada = false;

    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;

    @OneToOne(mappedBy = "parada", cascade = CascadeType.ALL, orphanRemoval = true)
    private Entrega entrega;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getDuracaoEstimada() {
        return duracaoEstimada;
    }

    public void setDuracaoEstimada(Integer duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }

    public Boolean getEntregaRealizada() {
        return entregaRealizada;
    }

    public void setEntregaRealizada(Boolean entregaRealizada) {
        this.entregaRealizada = entregaRealizada;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }
}

