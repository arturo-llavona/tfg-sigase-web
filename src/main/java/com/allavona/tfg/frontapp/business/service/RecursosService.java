package com.allavona.tfg.frontapp.business.service;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.model.Recurso;

import java.util.List;

public interface RecursosService {
    public List<Recurso> listar(Integer type, Boolean onlyAvailable) throws ApiException;
}
