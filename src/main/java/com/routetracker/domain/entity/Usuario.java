package com.routetracker.domain.entity;

import com.routetracker.domain.enums.StatusPessoa;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario",sequenceName = "seq_usuario",allocationSize = 1,initialValue = 1)
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    private String email;
    private String senha;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Acesso> acessos;

    @OneToOne
    private Pessoa pessoa;

    /* Autoridades = são os acesso, ou seja ROLE_ADMIN, ROLE_SECRETARIO,ROLE_FINANCEIRO*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.acessos;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    /*
    Tradução: A conta não expirou?
    Explicação: Indica se a conta do usuário ainda é válida no tempo, ou seja, se não foi desativada automaticamente por expiração.
    Exemplo de uso: Ideal para sistemas que limitam o uso de contas por tempo (ex: licenças temporárias).
     */
//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
    /*Tradução: A conta não está bloqueada?
    Explicação: Retorna true se a conta não estiver bloqueada por tentativas de login incorretas, ou manualmente.
    Exemplo de uso: Um status BLOQUEADO na entidade Pessoa ou Usuario pode estar ligado a esse método.
     */
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
    //}

    /*
    Tradução: Está habilitado?
    Explicação: Indica se o usuário está ativo no sistema e autorizado a se autenticar.
    Exemplo de uso: Pode estar relacionado a um campo status como ATIVO, INATIVO, BLOQUEADO.
    */
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }

    /*
    Tradução: Está habilitado?
    Explicação: Indica se o usuário está ativo no sistema e autorizado a se autenticar.
    Exemplo de uso: Pode estar relacionado a um campo status como ATIVO, INATIVO, BLOQUEADO.
     */
    @Override
    public boolean isEnabled() {
        return pessoa.getStatus() != StatusPessoa.ATIVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
