package com.allavona.tfg.frontapp.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/private")
public class HomePrivateController {
    @RequestMapping("/index")
    public String index() {
        return "private/index";
    }
}
