package com.seuprojeto.chamado.controller;

import com.seuprojeto.chamado.model.Usuario;
import com.seuprojeto.chamado.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/login";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }
}

