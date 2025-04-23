package com.seuprojeto.chamado.repository;

import com.seuprojeto.chamado.model.LogAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogAuditoriaRepository extends JpaRepository<LogAuditoria, Long> {
}