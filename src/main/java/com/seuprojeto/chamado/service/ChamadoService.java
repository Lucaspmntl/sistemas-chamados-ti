package com.seuprojeto.chamado.service;


import com.seuprojeto.chamado.model.Chamado;
import com.seuprojeto.chamado.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> listarTodos() {
        return chamadoRepository.findAll();
    }

    public Optional<Chamado> buscarPorId(Long id) {
        return chamadoRepository.findById(id);
    }

    public Chamado salvar(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }

    public Chamado atualizar(Long id, Chamado chamadoAtualizado) {
        return chamadoRepository.findById(id).map(chamado -> {
            chamado.setTitulo(chamadoAtualizado.getTitulo());
            chamado.setDescricao(chamadoAtualizado.getDescricao());
            chamado.setStatus(chamadoAtualizado.getStatus());
            chamado.setCategoria(chamadoAtualizado.getCategoria());
            chamado.setTecnico(chamadoAtualizado.getTecnico());
            return chamadoRepository.save(chamado);
        }).orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }


    public void deletar(Long id) {
        chamadoRepository.deleteById(id);
    }
}