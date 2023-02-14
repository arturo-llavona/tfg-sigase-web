package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.api.IncidentsApi;
import com.allavona.tfg.frontapp.business.webclient.model.ClasificacionIncidente;
import com.allavona.tfg.frontapp.business.webclient.model.Incidente;
import com.allavona.tfg.frontapp.business.webclient.model.TipoRecurso;
import com.allavona.tfg.frontapp.web.controller.utils.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = URLConstants.INCIDENTS_URL)
public class IncidentesRestController {
    final IncidentsApi api;

    public IncidentesRestController(IncidentsApi api) {
        this.api = api;
    }


    @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<List<Incidente>> buscarIncidentes(
            @RequestParam(value = "closed", required = false, defaultValue = "false") final boolean closed,
            Principal principal) throws ApiException {
        List<Incidente> listado = null;
        try {
            listado = api.buscarIncidentes(principal.getName(), closed);
            if ( listado != null ) {
                if (closed) {
                    listado.sort(Comparator.comparing(Incidente::getFechaFinalizacion).reversed());
                } else {
                    listado.sort(Comparator.comparing(Incidente::getFechaCreacion).reversed());
                }
            }

        } catch (Exception e) {

        }
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
    @RequestMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<Incidente> obtenerIncidente(
            @PathVariable(name="id", required = true) final Integer idIncidente,
            Principal principal) throws ApiException {

        Incidente incidente = null;
        try {
            incidente = api.obtenerIncidente(principal.getName(), idIncidente);
        } catch (Exception e) {

        }
        return Optional.ofNullable(incidente).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @RequestMapping(path = URLConstants.CLASSIFICATIONS_URL, produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity<List<ClasificacionIncidente>> buscarClasificacionIncidente(@RequestParam(value = "codigo", required = false) final String codigo) {
        List<ClasificacionIncidente> listado = null;
        try {
            listado = api.buscarClasificacionIncidente(codigo);
        } catch (Exception e) {

        }
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @RequestMapping(path = URLConstants.CLASSIFICATIONS_TEMPLATE_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<TipoRecurso>> buscarPlantillaClasificacionIncidente(@PathVariable(name="id", required = true) final Integer id) {
        List<TipoRecurso> listado = null;
        try {
            listado = api.buscarPlantillaClasificacionIncidente(id);
        } catch (Exception e) {

        }
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
