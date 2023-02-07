package com.allavona.tfg.frontapp.security;

import com.allavona.tfg.frontapp.business.webclient.api.UsersApi;
import com.allavona.tfg.frontapp.business.webclient.model.Login;
import com.allavona.tfg.frontapp.business.webclient.model.Usuario;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    final UsersApi api;

    public CustomAuthenticationProvider(UsersApi api) {
        this.api = api;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Login login = new Login();
        login.setUsername(name);
        login.setPassword(password);
        try {
            Usuario usuario = api.autenticar(login);
            if (usuario != null ) {
                usuario.setPassword(password);
                ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(name, password, authorities);
                CustomUserDetails userDetails = new CustomUserDetails(usuario, authorities);
                token.setDetails(userDetails);
                return token;
            } else {
                System.out.println("MAL");
                return null;
            }
        } catch ( Exception e ) {
            System.out.println("MAL");
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
