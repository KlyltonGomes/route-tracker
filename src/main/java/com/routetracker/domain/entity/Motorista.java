package com.routetracker.domain.entity;

import com.routetracker.domain.enums.TipoVeiculo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "motorista")
@SequenceGenerator(name = "seq_motorista", sequenceName = "seq_motorista", allocationSize = 1, initialValue = 1)
public class Motorista extends Pessoa {

    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String placa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVeiculo veiculo;

    // Relacionamento opcional com Admin
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin adminResponsavel;

    @ManyToOne
    @JoinColumn(name = "convite_id", nullable = true)
    private Convite convite;

    @OneToMany(mappedBy = "motorista", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rota> rotas = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public TipoVeiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(TipoVeiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Admin getAdminResponsavel() {
        return adminResponsavel;
    }

    public void setAdminResponsavel(Admin adminResponsavel) {
        this.adminResponsavel = adminResponsavel;
    }

    public Convite getConvite() {
        return convite;
    }

    public void setConvite(Convite convite) {
        this.convite = convite;
    }

    public List<Rota> getRotas() {
        return rotas;
    }

    public void setRotas(List<Rota> rotas) {
        this.rotas = rotas;
    }
}
