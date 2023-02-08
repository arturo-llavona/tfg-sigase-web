package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.business.webclient.api.ResourcesApi;
import com.allavona.tfg.frontapp.business.webclient.model.Recurso;
import com.allavona.tfg.frontapp.web.controller.utils.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = URLConstants.RESOURCES_URL)
public class RecursosRestController {
    final ResourcesApi api;

    public RecursosRestController(ResourcesApi api) {
        this.api = api;
    }


    @RequestMapping( produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public  ResponseEntity<List<Recurso>> listar(
            @RequestParam(value="type", required = false) final Integer idTipoRecurso,
            @RequestParam(value = "onlyAvailable", required = false, defaultValue = "true") final Boolean onlyAvailable) {
        List<Recurso> listado = null;
        try {
            listado = api.listar(idTipoRecurso, onlyAvailable);
        } catch (Exception e) {

        }
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
