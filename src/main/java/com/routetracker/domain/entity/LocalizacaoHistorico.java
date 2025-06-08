package com.routetracker.domain.entity;

import com.routetracker.domain.enums.StatusLocalizacao;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "LocalizacaoHistorico")
@SequenceGenerator(name = "seq_LocalizacaoHistorico", sequenceName = "seq_LocalizacaoHistorico", allocationSize = 1, initialValue = 1)
public class LocalizacaoHistorico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_LocalizacaoHistorico")
    private Long id;

    private Double latitude;
    private Double longitude;
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusLocalizacao status;

    @ManyToOne
    @JoinColumn(name = "motorista_id") //"nullable = false"
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "rota_id")
    private Rota rota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusLocalizacao getStatus() {
        return status;
    }

    public void setStatus(StatusLocalizacao status) {
        this.status = status;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }
}
