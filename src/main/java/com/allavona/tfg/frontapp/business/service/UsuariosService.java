package com.allavona.tfg.frontapp.business.service;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.model.Login;
import com.allavona.tfg.frontapp.business.webclient.model.Usuario;

public interface UsuariosService {
    public Usuario autenticar(Login login) throws ApiException;
}
