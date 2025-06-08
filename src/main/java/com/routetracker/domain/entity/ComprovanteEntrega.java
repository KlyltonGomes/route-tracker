package com.routetracker.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "comprovante_entrega")
@SequenceGenerator(name = "seq_comprovante_entrega", sequenceName = "seq_comprovante_entrega", allocationSize = 1, initialValue = 1)
public class ComprovanteEntrega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comprovante_entrega")
    private Long id;

    private String url;

    private LocalDateTime dataHoraEntrega;

    @ManyToOne
    @JoinColumn(name = "entrega_id", nullable = false)
    private Entrega entrega;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getDataEnvio() {
        return dataHoraEntrega;
    }

    public void setDataEnvio(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public Entrega getEntrega() {
        return entrega;
    }

    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    // Getters e setters
}
