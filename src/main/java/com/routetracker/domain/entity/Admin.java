package com.routetracker.domain.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "admin")
@SequenceGenerator(name = "seq_admin", sequenceName = "seq_admin", allocationSize = 1, initialValue = 1)
public class Admin  extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_admin")
    private Long id;

    @Column(name = "emailPlano")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plano_id")
    private Plano planoAtual;

    @Column(name = "FimAssinatura")
    private LocalDate dataFimAssinatura;

    @OneToMany(mappedBy = "adminResponsavel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Motorista> motoristas = new ArrayList<>();

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Convite> convites = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Plano getPlanoAtual() {
        return planoAtual;
    }

    public void setPlanoAtual(Plano planoAtual) {
        this.planoAtual = planoAtual;
    }

    public LocalDate getDataFimAssinatura() {
        return dataFimAssinatura;
    }

    public void setDataFimAssinatura(LocalDate dataFimAssinatura) {
        this.dataFimAssinatura = dataFimAssinatura;
    }

    public List<Motorista> getMotoristas() {
        return motoristas;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }

    public List<Convite> getConvites() {
        return convites;
    }

    public void setConvites(List<Convite> convites) {
        this.convites = convites;
    }
}
