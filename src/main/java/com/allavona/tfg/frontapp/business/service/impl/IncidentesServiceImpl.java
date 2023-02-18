package com.allavona.tfg.frontapp.business.service.impl;

import com.allavona.tfg.frontapp.business.service.IncidentesService;
import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.api.IncidentsApi;
import com.allavona.tfg.frontapp.business.webclient.model.ClasificacionIncidente;
import com.allavona.tfg.frontapp.business.webclient.model.Incidente;
import com.allavona.tfg.frontapp.business.webclient.model.IncidenteDTO;
import com.allavona.tfg.frontapp.business.webclient.model.TipoRecurso;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentesServiceImpl implements IncidentesService {
    final IncidentsApi api;

    public IncidentesServiceImpl(IncidentsApi api) {
        this.api = api;
    }
    @Override
    public List<Incidente> buscarIncidentes(String USER_NAME, Boolean closed) throws ApiException {
        return api.buscarIncidentes(USER_NAME, closed);
    }
    @Override
    public Incidente obtenerIncidente(String USER_NAME, Integer id) throws ApiException {
        return api.obtenerIncidente(USER_NAME, id);
    }
    @Override
    public List<ClasificacionIncidente> buscarClasificacionIncidente(String codigo) throws ApiException {
        return api.buscarClasificacionIncidente(codigo);
    }
    @Override
    public void crearIncidente(String USER_NAME, IncidenteDTO incidenteDTO) throws ApiException {
        api.crearIncidente(USER_NAME, incidenteDTO);
    }
    @Override
    public List<TipoRecurso> buscarPlantillaClasificacionIncidente(Integer id) throws ApiException {
        return api.buscarPlantillaClasificacionIncidente(id);
    }
}
