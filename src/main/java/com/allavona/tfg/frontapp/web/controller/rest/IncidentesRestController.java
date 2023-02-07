package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.api.IncidentsApi;
import com.allavona.tfg.frontapp.business.webclient.api.ResourcesApi;
import com.allavona.tfg.frontapp.business.webclient.model.Incidente;
import com.allavona.tfg.frontapp.security.CustomUserDetails;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/private/incidents")
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

}
