package com.seuprojeto.chamado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.seuprojeto.chamado.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {}
