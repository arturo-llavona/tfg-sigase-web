package com.allavona.tfg.frontapp.web.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    // En caso de que alguien intente acceder al raíz de la aplicación, es enviado al formulario de login.
    public String root() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    // Url de acceso al formulario de login
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    // Url de acceso al login cuando hubo un error
    public String loginError(Model model) {
        // Lo que se hace realmente, es establecer un atributo en el response "loginError" con valor true, y es enviado
        // al formulario de login. Mediante el atributo el frontal renderizará el mensaje de error al usuario.
        model.addAttribute("loginError", true);
        return "login";
    }
}