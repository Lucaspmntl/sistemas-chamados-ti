package com.seuprojeto.chamado.exception;
import com.seuprojeto.chamado.exception.ChamadoException;
import com.seuprojeto.chamado.exception.UsuarioException;
import com.seuprojeto.chamado.exception.ValidacaoException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioException.class)
    public String handleUsuarioException(UsuarioException ex, Model model) {
        model.addAttribute("erro", ex.getMessage());
        return "erro/usuario"; // página de erro personalizada para usuários
    }

    @ExceptionHandler(ChamadoException.class)
    public String handleChamadoException(ChamadoException ex, Model model) {
        model.addAttribute("erro", ex.getMessage());
        return "erro/chamado"; // página de erro personalizada para chamados
    }

    @ExceptionHandler(ValidacaoException.class)
    public String handleValidacaoException(ValidacaoException ex, Model model) {
        model.addAttribute("erro", ex.getMessage());
        return "erro/validacao"; // página de erro para validações
    }

    @ExceptionHandler(Exception.class) // para qualquer outro erro inesperado
    public String handleException(Exception ex, Model model) {
        model.addAttribute("erro", "Erro inesperado: " + ex.getMessage());
        return "erro/geral"; // página de erro genérica
    }
}