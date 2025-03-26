package com.seuprojeto.chamado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.chamado.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {}