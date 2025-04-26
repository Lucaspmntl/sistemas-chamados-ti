package com.seuprojeto.chamado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login/login"; // nome do HTML
    }

    @GetMapping("/")
    public String redirecionar() {
        return "redirect:/chamados";
    }
}