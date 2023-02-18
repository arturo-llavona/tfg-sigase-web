package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.business.service.RecursosService;
import com.allavona.tfg.frontapp.business.webclient.api.ResourcesApi;
import com.allavona.tfg.frontapp.business.webclient.model.Recurso;
import com.allavona.tfg.frontapp.web.controller.utils.URLConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = URLConstants.RESOURCES_URL)
public class RecursosRestController {
    final RecursosService recursosService;
    public RecursosRestController(RecursosService recursosService) {
        this.recursosService = recursosService;
    }

    @RequestMapping( produces = {MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
    public  ResponseEntity<List<Recurso>> listar(
            @RequestParam(value="type", required = false) final Integer idTipoRecurso,
            @RequestParam(value = "onlyAvailable", required = false, defaultValue = "true") final Boolean onlyAvailable) {
        List<Recurso> listado = null;
        try {
            // Se llama al API para obtener el listado
            listado = recursosService.listar(idTipoRecurso, onlyAvailable);
        } catch (Exception e) {

        }
        return Optional.ofNullable(listado).map(ResponseEntity::ok).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
