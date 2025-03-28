package com.seuprojeto.chamado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.chamado.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, Long> {}