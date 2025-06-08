package com.routetracker.domain.entity;

import com.routetracker.domain.enums.StatusEntrega;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "entrega")
@SequenceGenerator(name = "seq_entrega", sequenceName = "seq_entrega", allocationSize = 1, initialValue = 1)
public class Entrega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entrega")
    private Long id;

    private LocalDateTime dataHoraEntrega;

    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;

    private String observacao;

    private Double quilometragemPercorrida;

    private LocalDateTime inicioEntrega;

    private LocalDateTime finalEntrega;

    @ManyToOne
    @JoinColumn(name = "motorista_id", nullable = false)
    private Motorista motorista;

    @OneToOne
    @JoinColumn(name = "parada_id")
    private Parada parada;

    // Entrega -> Comprovantes (um para muitos)
    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComprovanteEntrega> comprovantes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHoraEntrega() {
        return dataHoraEntrega;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public StatusEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getQuilometragemPercorrida() {
        return quilometragemPercorrida;
    }

    public void setQuilometragemPercorrida(Double quilometragemPercorrida) {
        this.quilometragemPercorrida = quilometragemPercorrida;
    }

    public LocalDateTime getInicioEntrega() {
        return inicioEntrega;
    }

    public void setInicioEntrega(LocalDateTime inicioEntrega) {
        this.inicioEntrega = inicioEntrega;
    }

    public LocalDateTime getFinalEntrega() {
        return finalEntrega;
    }

    public void setFinalEntrega(LocalDateTime finalEntrega) {
        this.finalEntrega = finalEntrega;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Parada getParada() {
        return parada;
    }

    public void setParada(Parada parada) {
        this.parada = parada;
    }

    public List<ComprovanteEntrega> getComprovantes() {
        return comprovantes;
    }

    public void setComprovantes(List<ComprovanteEntrega> comprovantes) {
        this.comprovantes = comprovantes;
    }
}
