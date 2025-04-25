package com.seuprojeto.chamado.controller;

import com.seuprojeto.chamado.service.CategoriaService;
import com.seuprojeto.chamado.model.Chamado;
import com.seuprojeto.chamado.model.Status;
import com.seuprojeto.chamado.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/chamados")
    public String listarChamados(Model model) {
        model.addAttribute("chamados", chamadoService.listarTodos());
        return "chamados";
    }

    @PostMapping("/{id}/atualizar-status")
    public String atualizarStatus(@PathVariable Long id, @RequestParam Status status) {
        Chamado chamado = chamadoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
        chamado.setStatus(status);
        chamadoService.salvar(chamado);
        return "redirect:/chamados/" + id;
    }


    @GetMapping("/novo")
    public String novoChamado(Model model) {
        model.addAttribute("chamado", new Chamado());
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("statusList", Status.values());
        return "chamados/form";
    }

    @PostMapping("/salvar")
    public String salvarChamado(@ModelAttribute Chamado chamado) {
        chamadoService.salvar(chamado);
        return "redirect:/chamados";
    }

    @GetMapping("/{id}")
    public String visualizarChamado(@PathVariable Long id, Model model) {
        model.addAttribute("chamado", chamadoService.buscarPorId(id));
        return "chamados/detalhes";
    }
}