package com.seuprojeto.chamado.config;

import com.seuprojeto.chamado.model.Chamado;
import com.seuprojeto.chamado.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@ControllerAdvice
public class GlobalController {

    @Autowired
    private ChamadoService chamadoService;

    @ModelAttribute("ultimoChamado")
    public Chamado getUltimoChamado() {
        return chamadoService.buscarUltimoChamado().orElse(null);
    }
}
