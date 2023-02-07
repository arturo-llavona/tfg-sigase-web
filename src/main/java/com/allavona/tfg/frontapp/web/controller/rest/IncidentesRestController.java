package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.api.IncidentsApi;
import com.allavona.tfg.frontapp.business.webclient.model.ClasificacionIncidente;
import com.allavona.tfg.frontapp.business.webclient.model.Incidente;
import com.allavona.tfg.frontapp.business.webclient.model.TipoRecurso;
import com.allavona.tfg.frontapp.security.CustomUserDetails;
import com.allavona.tfg.frontapp.web.controller.utils.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
            Authentication authentication) throws ApiException {
        CustomUserDetails userDetails = (CustomUserDetails)  authentication.getDetails();
        List<Incidente> listado = null;
        try {
            listado = api.buscarIncidentes(userDetails.getUser().getIdUsuario(), closed);
        } catch (Exception e) {

        }
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
    @RequestMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<Incidente> obtenerIncidente(
            @PathVariable(name="id", required = true) final Integer idIncidente,
            Authentication authentication) throws ApiException {
        CustomUserDetails userDetails = (CustomUserDetails)  authentication.getDetails();

        Incidente incidente = null;
        try {
            incidente = api.obtenerIncidente(userDetails.getUser().getIdUsuario(), idIncidente);
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
