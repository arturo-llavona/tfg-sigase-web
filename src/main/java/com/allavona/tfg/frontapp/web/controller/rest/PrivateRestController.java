package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.business.webclient.ApiException;
import com.allavona.tfg.frontapp.business.webclient.api.ResourcesApi;
import com.allavona.tfg.frontapp.business.webclient.model.Recurso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/private")
public class PrivateRestController {
    final ResourcesApi api;

    public PrivateRestController(ResourcesApi api) {
        this.api = api;
    }

    @GetMapping("/sample")
    List<Recurso> getTest(Authentication authentication) throws ApiException {
        List<Recurso> recursos = api.listar(null, true);
        return recursos;
    }
}
