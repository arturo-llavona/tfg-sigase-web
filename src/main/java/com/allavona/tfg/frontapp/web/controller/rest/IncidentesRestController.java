package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.business.service.IncidentesService;
import com.allavona.tfg.frontapp.business.webclient.model.ClasificacionIncidente;
import com.allavona.tfg.frontapp.business.webclient.model.Incidente;
import com.allavona.tfg.frontapp.business.webclient.model.IncidenteDTO;
import com.allavona.tfg.frontapp.business.webclient.model.TipoRecurso;
import com.allavona.tfg.frontapp.web.controller.utils.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = URLConstants.INCIDENTS_URL)
public class IncidentesRestController {
    final IncidentesService incidentesService;
    public IncidentesRestController(IncidentesService incidentesService) {
        this.incidentesService = incidentesService;
    }
    @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<List<Incidente>> buscarIncidentes(
            @RequestParam(value = "closed", required = false, defaultValue = "false") final boolean closed,
            Principal principal) {
        List<Incidente> listado = null;
        try {
            // Se llama a la capa de servicios para obtener los incidentes. Se pasa como parámetro el username del
            // usuario logado.
            listado = incidentesService.buscarIncidentes(principal.getName(), closed);
            if ( listado != null ) {
                if (closed) {
                    // Si estamos queriendo ver los incidentes finalizados, ordenamos por fecha de finalización.
                    listado.sort(Comparator.comparing(Incidente::getFechaFinalizacion).reversed());
                } else {
                    // Si estamos queriendo ver los incidentes en curso, ordenamos por fecha de creación.
                    listado.sort(Comparator.comparing(Incidente::getFechaCreacion).reversed());
                }
            }

        } catch (Exception e) {

        }
        // En caso de haber obtenido un listado, devolvemos un OK (200) con el listado. En caso contrario se devuelve un
        // BAD_REQUEST (400)
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
    @RequestMapping(path="/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.GET)
    public ResponseEntity<Incidente> obtenerIncidente(
            @PathVariable(name="id", required = true) final Integer idIncidente,
            Principal principal) {

        Incidente incidente = null;
        try {
            // Se llama a la capa de servicios para obtener el detalle del incidente. Se pasa como parámetro el username
            // del usuario que está identificado.
            incidente = incidentesService.obtenerIncidente(principal.getName(), idIncidente);
        } catch (Exception e) {

        }
        // En caso de haber obtenido un incidente, devolvemos un OK (200) con el incidente. En caso contrario se devuelve un
        // BAD_REQUEST (400)
        return Optional.ofNullable(incidente).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @RequestMapping(path = URLConstants.CLASSIFICATIONS_URL, produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public ResponseEntity<List<ClasificacionIncidente>> buscarClasificacionIncidente(@RequestParam(value = "codigo", required = false) final String codigo) {
        List<ClasificacionIncidente> listado = null;
        try {
            // Se llama a la capa de servicios para obtener las posibles clasificaciones de incidentes a partir del código
            // recibido como parámetro.
            listado = incidentesService.buscarClasificacionIncidente(codigo);
        } catch (Exception e) {

        }
        // En caso de haber obtenido un listado, devolvemos un OK (200) con el listado. En caso contrario se devuelve un
        // BAD_REQUEST (400)
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @RequestMapping(path = URLConstants.CLASSIFICATIONS_TEMPLATE_URL, produces = {MediaType.APPLICATION_JSON_VALUE}, method = RequestMethod.GET)
    public ResponseEntity<List<TipoRecurso>> buscarPlantillaClasificacionIncidente(@PathVariable(name="id", required = true) final Integer id) {
        List<TipoRecurso> listado = null;
        try {
            // Se llama a la capa de servicios para obtener la plantilla de recursos que deben movilizarse para una
            // clasificación determinada.
            listado = incidentesService.buscarPlantillaClasificacionIncidente(id);
        } catch (Exception e) {

        }
        // En caso de haber obtenido un listado, devolvemos un OK (200) con el listado. En caso contrario se devuelve un
        // BAD_REQUEST (400)
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE } , method = RequestMethod.POST)
    public ResponseEntity crearIncidente(@RequestBody final IncidenteDTO incidente, Principal principal)  {
        try {
            // Se llama a la capa de servicios para crear un incidente. Se pasa como parámetro el username del usuario
            // que está identificado. En caso de crearse correctamente, se devuelve un CREATED (201)
            incidentesService.crearIncidente(principal.getName(), incidente);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // En caso de que no se haya conseguido crear correctamente se devuelve un BAD_REQUEST (400)
            return ResponseEntity.badRequest().build();
        }
    }
}