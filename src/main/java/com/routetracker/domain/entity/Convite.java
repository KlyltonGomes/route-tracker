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

    @OneToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Column(nullable = false)
    private String codigo;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConvite statusConvite;

    @Column(name = "convite_utilizado")
    private Boolean  utilizado;

}
