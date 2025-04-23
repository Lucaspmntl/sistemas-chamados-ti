package com.seuprojeto.chamado.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroController implements ErrorController {

    @RequestMapping("/erro")
    public String handleError() {
        return "erro/pagina-erro";
    }

}