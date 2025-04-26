package com.seuprojeto.chamado.config;


import com.seuprojeto.chamado.model.Categoria;
import com.seuprojeto.chamado.repository.CategoriaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

    @Component
    public class CategoriaInicializador {

        @Autowired
        private CategoriaRepository categoriaRepository;

        @PostConstruct
        public void init() {
            if (categoriaRepository.count() == 0) {
                categoriaRepository.save(new Categoria("Hardware"));
                categoriaRepository.save(new Categoria("Software"));
                categoriaRepository.save(new Categoria("Rede"));
                categoriaRepository.save(new Categoria("Segurança da Informação"));
                categoriaRepository.save(new Categoria("Acesso à Internet"));
                categoriaRepository.save(new Categoria("Suporte ao Usuário"));
                categoriaRepository.save(new Categoria("Telefonia"));
                categoriaRepository.save(new Categoria("Banco de Dados"));
            }
        }
    }

