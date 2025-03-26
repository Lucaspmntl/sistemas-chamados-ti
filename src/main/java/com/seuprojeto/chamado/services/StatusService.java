package com.seuprojeto.chamado.services;

import com.seuprojeto.chamado.model.Status;
import com.seuprojeto.chamado.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public List<Status> listarStatus() {
        return statusRepository.findAll();
    }

    public Status salvarStatus(Status status) {
        return statusRepository.save(status);
    }
}