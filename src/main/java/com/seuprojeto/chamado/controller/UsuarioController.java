package com.seuprojeto.chamado.controller;

import com.seuprojeto.chamado.model.Usuario;
import com.seuprojeto.chamado.service.EmailService;
import com.seuprojeto.chamado.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Autowired
    private EmailService emailService;

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "usuarios/cadastro"; // volta para a página de cadastro se tiver erro
        }

        usuarioService.salvar(usuario);

        // Enviar o email de boas-vindas
        emailService.enviarEmail(
                usuario.getEmail(),
                "Cadastro Realizado!",
                "Olá " + usuario.getNome() + ", seu cadastro foi concluído com sucesso!"
        );

        redirectAttributes.addFlashAttribute("mensagem", "Cadastro realizado com sucesso!");
        return "redirect:/login";
    }

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuarios/lista";
    }
}

