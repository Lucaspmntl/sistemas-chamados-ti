package com.seuprojeto.chamado.controller;

import com.seuprojeto.chamado.model.Categoria;
import com.seuprojeto.chamado.model.Usuario;
import com.seuprojeto.chamado.repository.ChamadoRepository;
import com.seuprojeto.chamado.service.CategoriaService;
import com.seuprojeto.chamado.model.Chamado;
import com.seuprojeto.chamado.model.Status;
import com.seuprojeto.chamado.service.ChamadoService;
import com.seuprojeto.chamado.service.EmailService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/chamados")
public class ChamadoController {

    @PostConstruct
    public void init() {
        System.out.println("ChamadoController carregado!");
    }

    @Autowired
    private ChamadoService chamadoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping("/")
    public String home(Model model) {
        chamadoService.buscarUltimoChamado().ifPresent(ultimo -> model.addAttribute("ultimoChamado", ultimo));
        return "index";
    }


    @GetMapping("")
    public String listarChamados(Model model, @RequestParam(value = "highlight", required = false) Long highlightId) {
        List<Chamado> chamados = chamadoService.listarTodos();
        model.addAttribute("chamados", chamados);
        if (highlightId != null) {
            model.addAttribute("novoChamadoId", highlightId);
        }
        return "chamados/chamados";
    }


    @Autowired
    private EmailService emailService;

    @PostMapping("/{id}/atualizar-status")
    public String atualizarStatus(@PathVariable Long id,
                                  @RequestParam Status status,
                                  RedirectAttributes redirectAttributes,
                                  @AuthenticationPrincipal Usuario usuarioLogado) {

        Chamado chamado = chamadoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        chamado.setStatus(status);

        if (status == Status.CONCLUIDO) {
            chamado.setDataFechamento(LocalDateTime.now());
            chamado.setTecnico(usuarioLogado);
        }

        chamadoService.salvar(chamado);

        // Enviar email para o dono do chamado
        String emailDestinatario = chamado.getUsuario().getEmail();
        String assunto = "Atualização do seu chamado";
        String corpo = "Olá " + chamado.getUsuario().getNome() +
                ",\n\nO status do seu chamado (ID: " + chamado.getId() +
                ") foi alterado para: " + chamado.getStatus() + ".\n\nObrigado!";

        emailService.enviarEmail(emailDestinatario, assunto, corpo);

        redirectAttributes.addFlashAttribute("mensagemSucesso", "Status atualizado com sucesso!");
        return "redirect:/chamados?highlight=" + chamado.getId();
    }

    @GetMapping("/{id}/editar")
    public String editarChamado(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Chamado chamado = chamadoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Chamado não encontrado"));

        if (chamado.getStatus() == Status.CONCLUIDO) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Chamados concluídos não podem ser editados.");
            return "redirect:/chamados";
        }

        model.addAttribute("chamado", chamado);
        model.addAttribute("statusList", Status.values());
        return "chamados/editar";
    }

    @GetMapping("/novo")
    public String novoChamado(Model model) {
        try {
            model.addAttribute("chamado", new Chamado());
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("statusList", Status.values());
            return "chamados/novo";
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return "erro";
        }
    }

    @PostMapping("/{id}/salvar")
    public String salvarEdicaoChamado(@PathVariable Long id,
                                      @ModelAttribute Chamado chamado,
                                      RedirectAttributes redirectAttributes,
                                      @AuthenticationPrincipal Usuario usuarioLogado) {

        Chamado existente = chamadoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        if (existente.getStatus() == Status.CONCLUIDO) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Chamados concluídos não podem ser editados.");
            return "redirect:/chamados";
        }

        // Atualize apenas os campos permitidos
        existente.setStatus(chamado.getStatus());

        if (chamado.getStatus() == Status.CONCLUIDO) {
            existente.setDataFechamento(LocalDateTime.now());
            existente.setTecnico(usuarioLogado);
        }

        chamadoService.salvar(existente);

        redirectAttributes.addFlashAttribute("mensagemSucesso", "Chamado atualizado com sucesso!");
        return "redirect:/chamados?highlight=" + existente.getId();
    }

    @PostMapping("/salvar")
    public String salvarChamado(@ModelAttribute Chamado chamado,
                                @RequestParam("categoriaId") Long categoriaId,
                                RedirectAttributes redirectAttributes,
                                @AuthenticationPrincipal Usuario usuarioLogado) {

        Categoria categoria = categoriaService.buscarPorId(categoriaId)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        chamado.setCategoria(categoria);
        chamado.setUsuario(usuarioLogado); // quem abriu o chamado
        chamado.setStatus(Status.ABERTO);
        chamado.setDataAbertura(LocalDateTime.now());

        chamadoService.salvar(chamado);

        redirectAttributes.addFlashAttribute("mensagemSucesso", "Chamado aberto com sucesso!");
        return "redirect:/chamados?highlight=" + chamado.getId();
    }

    @GetMapping("/{id}")
    public String visualizarChamado(@PathVariable Long id, Model model) {
        Chamado chamado = chamadoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        model.addAttribute("chamado", chamado);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        String dataAberturaFormatada = chamado.getDataAbertura() != null
                ? chamado.getDataAbertura().format(formatter)
                : null;

        String dataFechamentoFormatada = chamado.getDataFechamento() != null
                ? chamado.getDataFechamento().format(formatter)
                : null;

        model.addAttribute("dataAberturaFormatada", dataAberturaFormatada);
        model.addAttribute("dataFechamentoFormatada", dataFechamentoFormatada);

        return "chamados/detalhes";
    }

    @PostMapping("/{id}/excluir")
    public String excluirChamado(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        Chamado chamado = chamadoService.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        if (chamado.getStatus() != Status.CONCLUIDO && chamado.getStatus() != Status.CANCELADO) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Somente chamados concluídos ou cancelados podem ser excluídos.");
            return "redirect:/chamados";
        }

        chamadoService.deletar(id);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Chamado excluído com sucesso!");
        return "redirect:/chamados";
    }
}