package com.allavona.tfg.frontapp.security;

import com.allavona.tfg.frontapp.business.service.UsuariosService;
import com.allavona.tfg.frontapp.business.webclient.api.UsersApi;
import com.allavona.tfg.frontapp.business.webclient.model.Login;
import com.allavona.tfg.frontapp.business.webclient.model.Usuario;
import com.allavona.tfg.frontapp.web.controller.enums.TipoUsuarioEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final UsuariosService usuariosService;
    private static Logger logger = LogManager.getLogger();
    public CustomAuthenticationProvider(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        Login login = new Login();
        login.setUsername(name);
        login.setPassword(password);
        try {
            // Se realiza una llamada a través del webclient, para comprobar que existe un usuario con las credenciales
            // introducidas
            Usuario usuario = usuariosService.autenticar(login);
            if (usuario != null ) {
                // En caso de haber encontrado el usuario, generamos un Principal personalizado, que además de
                // username y password, contendrá otros datos, como el identificador del usuario, su tipo,
                // su nombre y sus apellidos.
                // Como Authority le añadimos el string correspondiente a su tipo de usuario.
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority(TipoUsuarioEnum.valueOf(usuario.getTipoUsuario()).toString()));
                String apellidos = StringUtils.concat(usuario.getApellido1(), " ", usuario.getApellido2()).trim();
                UserInfo userInfo = UserInfo.builder().name(name).id(usuario.getIdUsuario()).tipoUsuario(usuario.getTipoUsuario()).nombre(usuario.getNombre()).apellidos(apellidos).build();
                return new UsernamePasswordAuthenticationToken(userInfo, authentication.getCredentials(), authorities);
            } else {
                logger.warn("Login incorrecto");
                return null;
            }
        } catch ( Exception e ) {
            logger.error("Ha ocurrido un error al intentar hacer el login");
            return null;
        }
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
