package com.seuprojeto.chamado.services;

import com.seuprojeto.chamado.model.Tecnico;
import com.seuprojeto.chamado.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Tecnico> listarTecnicos() {
        return tecnicoRepository.findAll();
    }

    public Tecnico salvarTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }
}