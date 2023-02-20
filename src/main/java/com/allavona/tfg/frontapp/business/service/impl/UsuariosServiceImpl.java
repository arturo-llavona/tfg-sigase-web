package com.allavona.tfg.frontapp.business.service.impl;

import com.allavona.tfg.frontapp.business.service.UsuariosService;
import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.api.UsersApi;
import com.allavona.tfg.frontapp.business.webclient.model.Login;
import com.allavona.tfg.frontapp.business.webclient.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    final UsersApi api;

    public UsuariosServiceImpl(UsersApi api) {
        this.api = api;
    }
    @Override
    public Usuario autenticar(Login login) throws ApiException {
        return api.autenticar(login);
    }
}
