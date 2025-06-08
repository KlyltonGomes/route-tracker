package com.routetracker.domain.entity;

import com.routetracker.domain.enums.StatusConvite;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "convite")
@SequenceGenerator(name = "seq_convite", sequenceName = "seq_convite", allocationSize = 1, initialValue = 1)
public class Convite implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_convite")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConvite statusConvite;

    @Column(name = "convite_utilizado")
    private Boolean  utilizado;

    @ManyToOne
    @JoinColumn(name = "admin_id") // FK para admin
    private Admin admin;

    @OneToOne(mappedBy = "convite")
    private Motorista motorista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public StatusConvite getStatusConvite() {
        return statusConvite;
    }

    public void setStatusConvite(StatusConvite statusConvite) {
        this.statusConvite = statusConvite;
    }

    public Boolean getUtilizado() {
        return utilizado;
    }

    public void setUtilizado(Boolean utilizado) {
        this.utilizado = utilizado;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}
/*

Exemplo de uso no fluxo de cadastro:

Admin entra no painel → gera um código.
Motorista se cadastra usando esse código → valida o código → grava o Convite no Motorista.
Se não tiver código, o campo convite no Motorista fica null.
 */