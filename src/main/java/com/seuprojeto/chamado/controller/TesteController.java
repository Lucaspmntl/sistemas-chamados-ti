package com.seuprojeto.chamado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teste")
public class TesteController {

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong!";
    }
}

