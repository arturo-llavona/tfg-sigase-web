package com.allavona.tfg.frontapp.business.service.impl;

import com.allavona.tfg.frontapp.business.service.RecursosService;
import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.api.ResourcesApi;
import com.allavona.tfg.frontapp.business.webclient.model.Recurso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursosServiceImpl implements RecursosService {
    private final ResourcesApi api;

    public RecursosServiceImpl(ResourcesApi api) {
        this.api = api;
    }
    @Override
    public List<Recurso> listar(Integer type, Boolean onlyAvailable) throws ApiException {
        return api.listar(type, onlyAvailable);
    }
}
