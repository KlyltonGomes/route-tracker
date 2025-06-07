package com.routetracker.domain.entity;

import com.routetracker.domain.enums.TipoVeiculo;
import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

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
}
