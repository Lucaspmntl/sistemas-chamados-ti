package com.seuprojeto.chamado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seuprojeto.chamado.model.Chamado;
import com.seuprojeto.chamado.model.Status;
import com.seuprojeto.chamado.model.Usuario;

import java.util.List;

public interface ChamadoRepository extends JpaRepository<Chamado, Long> {
    List<Chamado> findByUsuario(Usuario usuario);
    List<Chamado> findByTecnico(Usuario tecnico);
    List<Chamado> findByStatus(Status status);
}