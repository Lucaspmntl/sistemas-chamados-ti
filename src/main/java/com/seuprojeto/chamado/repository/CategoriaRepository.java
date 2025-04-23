package com.seuprojeto.chamado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seuprojeto.chamado.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}