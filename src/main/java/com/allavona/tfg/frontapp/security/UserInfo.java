package com.allavona.tfg.frontapp.security;

import lombok.Builder;
import lombok.Data;

import javax.security.auth.Subject;
import java.security.Principal;

@Data
@Builder
public class UserInfo implements Principal {
    private Integer id;
    private String name;
    private Integer tipoUsuario;
    private String nombre;
    private String apellidos;

    @Override
    public boolean implies(Subject subject) {
        return Principal.super.implies(subject);
    }
}
