package com.allavona.tfg.frontapp.web.controller.rest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.stream.Stream;

@Controller
@RequestMapping(path = "/private")
public class HomePrivateController {
    @RequestMapping("/index")
    public String userIndex(Authentication authentication) {
        return "private/index";
    }
}
