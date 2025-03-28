package com.seuprojeto.chamado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.chamado.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {}