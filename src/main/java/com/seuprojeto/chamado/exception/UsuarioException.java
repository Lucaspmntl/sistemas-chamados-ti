package com.seuprojeto.chamado.exception;

public class UsuarioException extends RuntimeException {
    public UsuarioException(String mensagem) {
        super(mensagem);
    }
}