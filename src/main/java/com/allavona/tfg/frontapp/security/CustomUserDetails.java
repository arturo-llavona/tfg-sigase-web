package com.allavona.tfg.frontapp.security;

import com.allavona.tfg.frontapp.business.webclient.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Usuario user;
    List<GrantedAuthority> authorities;

    public CustomUserDetails(Usuario user, List<GrantedAuthority> authorities ) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.authorities = authorities;
        this.user = user;
    }

    public Usuario getUser() {
        return this.user;
    }
}
