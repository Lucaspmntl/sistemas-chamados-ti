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

    @Autowired
    private EmailService emailService;

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        if (!model.containsAttribute("usuario")) {
            model.addAttribute("usuario", new Usuario());
        }
        return "usuarios/cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "usuarios/cadastro";
        }

        if (usuarioService.emailJaExiste(usuario.getEmail())) {
            model.addAttribute("erroEmail", true);
            model.addAttribute("usuario", usuario);
            return "usuarios/cadastro";
        }

        usuarioService.salvar(usuario);

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
