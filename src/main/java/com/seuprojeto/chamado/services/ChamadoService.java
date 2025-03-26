package com.seuprojeto.chamado.services;


import com.seuprojeto.chamado.model.Chamado;
import com.seuprojeto.chamado.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> listarChamados() {
        return chamadoRepository.findAll();
    }

    public Chamado salvarChamado(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }
}