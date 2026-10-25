package com.example.demo.domain.model;


import com.example.demo.domain.model.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name="usuario")


public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String email;

    private String senha;

    private String telefone;

    @Enumerated(EnumType.STRING)
    private StatusUsuario statusUsuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(statusUsuario == StatusUsuario.ROLE_ADMIN)
        return List.of(
                new SimpleGrantedAuthority("ROLE_ADIN"),
                new SimpleGrantedAuthority("ROLE_MORADOR"));
        return List.of(
                new SimpleGrantedAuthority("ROLE_MORADOR"));
    }

    @Override
    public @Nullable String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}


