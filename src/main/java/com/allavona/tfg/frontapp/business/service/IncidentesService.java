package com.allavona.tfg.frontapp.business.service;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.model.ClasificacionIncidente;
import com.allavona.tfg.frontapp.business.webclient.model.Incidente;
import com.allavona.tfg.frontapp.business.webclient.model.IncidenteDTO;
import com.allavona.tfg.frontapp.business.webclient.model.TipoRecurso;

import java.util.List;

public interface IncidentesService {
    // Método para buscar incidentes.
    List<Incidente> buscarIncidentes(String USER_NAME, Boolean closed) throws ApiException;
    // Método para obtener el detalle de un incidente a partir de su identificador.
    Incidente obtenerIncidente(String USER_NAME, Integer id) throws ApiException;
    // Método para buscar las diferentes clasificaciones de incidentes existentes a partir de su código.
    List<ClasificacionIncidente> buscarClasificacionIncidente(String codigo) throws ApiException;
    // Método para crear un incidente.
    void crearIncidente(String USER_NAME, IncidenteDTO incidenteDTO) throws ApiException;
    // Método para buscar la plantilla de recursos recomendados a movilizar de un incidente a partir de su clasificación.
    List<TipoRecurso> buscarPlantillaClasificacionIncidente(Integer id) throws ApiException;
}
