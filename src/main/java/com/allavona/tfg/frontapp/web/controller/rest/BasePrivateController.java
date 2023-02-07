package com.allavona.tfg.frontapp.web.controller.rest;

import com.allavona.tfg.frontapp.web.bean.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BasePrivateController {
    @GetMapping("/private/sample")
    Test getTest() {
        Test t = new Test();
        t.setTexto("prueba");
        t.setFecha(new Date());
        return t;
    }
}
