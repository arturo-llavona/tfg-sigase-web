package com.allavona.tfg.frontapp.business.service;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.model.ClasificacionIncidente;
import com.allavona.tfg.frontapp.business.webclient.model.Incidente;
import com.allavona.tfg.frontapp.business.webclient.model.IncidenteDTO;
import com.allavona.tfg.frontapp.business.webclient.model.TipoRecurso;

import java.util.List;

public interface IncidentesService {
    public List<Incidente> buscarIncidentes(String USER_NAME, Boolean closed) throws ApiException;
    public Incidente obtenerIncidente(String USER_NAME, Integer id) throws ApiException;
    public List<ClasificacionIncidente> buscarClasificacionIncidente(String codigo) throws ApiException;
    public void crearIncidente(String USER_NAME, IncidenteDTO incidenteDTO) throws ApiException;
    public List<TipoRecurso> buscarPlantillaClasificacionIncidente(Integer id) throws ApiException;
}
