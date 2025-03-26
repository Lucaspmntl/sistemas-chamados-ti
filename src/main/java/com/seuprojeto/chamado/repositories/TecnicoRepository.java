package com.seuprojeto.chamado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.chamado.model.Tecnico;


@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {}