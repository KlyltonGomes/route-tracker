package com.routetracker.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "plano")
@SequenceGenerator(name = "seq_plano", sequenceName = "seq_plano", allocationSize = 1, initialValue = 1)
public class Plano implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_plano")
    private Long id;

    private String nome;

    private Integer limiteMotoristas;

    private BigDecimal precoMensal;

    public Plano() {}

    public Plano(String nome, Integer limiteMotoristas, BigDecimal precoMensal) {
        this.nome = nome;
        this.limiteMotoristas = limiteMotoristas;
        this.precoMensal = precoMensal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getLimiteMotoristas() {
        return limiteMotoristas;
    }

    public void setLimiteMotoristas(Integer limiteMotoristas) {
        this.limiteMotoristas = limiteMotoristas;
    }

    public BigDecimal getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(BigDecimal precoMensal) {
        this.precoMensal = precoMensal;
    }
}

