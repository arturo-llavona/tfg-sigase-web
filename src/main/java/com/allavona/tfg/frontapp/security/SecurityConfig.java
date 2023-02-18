package com.allavona.tfg.frontapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Autowired
    private CustomAuthenticationProvider authProvider;
    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        // Personalizamos nuestro proveedor de autenticación, estableciendo nuestra propia implementación.
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Se configura la seguridad de la aplicación.
        // Establecemos las rutas públicas, y las privadas que necesitan que el usuario se encuentre identificado.
        // Se configura la url de acceso al login, la url en caso de error y la url de acceso una vez el usuario se
        // ha identificado.
        http
                .authorizeRequests((authorize) -> authorize
                        .antMatchers("/css/**", "/index").permitAll()
                        .antMatchers("/private/**").authenticated()
                )
                .formLogin((formLogin) -> formLogin
                        .loginPage("/login")
                        .failureUrl("/login-error")
                        .defaultSuccessUrl("/private/index", true)
                ).logout((logout) -> logout.permitAll());
        return http.build();
    }
}