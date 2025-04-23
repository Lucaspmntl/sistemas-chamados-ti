package com.seuprojeto.chamado.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToMany(mappedBy = "usuario")
    private List<Chamado> chamados;

    // Getters e Setters abaixo, caso precise
}