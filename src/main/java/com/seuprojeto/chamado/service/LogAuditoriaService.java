package com.seuprojeto.chamado.service;

import com.seuprojeto.chamado.model.LogAuditoria;
import com.seuprojeto.chamado.repository.LogAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogAuditoriaService {

    @Autowired
    private LogAuditoriaRepository logAuditoriaRepository;

    public void registrar(String operacao, String usuario) {
        LogAuditoria log = new LogAuditoria();
        log.setOperacao(operacao);
        log.setUsuario(usuario);
        log.setDataHora(LocalDateTime.now());
        logAuditoriaRepository.save(log);
    }
}