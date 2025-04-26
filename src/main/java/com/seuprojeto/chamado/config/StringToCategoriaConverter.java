package com.seuprojeto.chamado.config;

import com.seuprojeto.chamado.model.Categoria;
import com.seuprojeto.chamado.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCategoriaConverter implements Converter<String, Categoria> {

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public Categoria convert(String id) {
        if (id == null || id.isEmpty()) return null;
        Long categoriaId = Long.valueOf(id);
        return categoriaService.buscarPorId(categoriaId).orElse(null);
    }
}
