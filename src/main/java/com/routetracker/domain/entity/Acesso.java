package com.routetracker.domain.entity;

import com.routetracker.domain.enums.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso",sequenceName = "seq_acesso", initialValue = 1,allocationSize = 1)
public class Acesso implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;

    @Column(nullable = false)//, unique = true)
    @Enumerated(EnumType.STRING) // enum
    private Role descricao; // acesso ex: ROLE_ADMIN ou ROLE_MOTORISTA

    @Override
    public String getAuthority() {
        return this.descricao.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getDescricao() {
        return descricao;
    }

    public void setDescricao(Role descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acesso acesso = (Acesso) o;
        return Objects.equals(id, acesso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
