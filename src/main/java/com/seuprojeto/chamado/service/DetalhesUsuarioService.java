package com.seuprojeto.chamado.service;

import com.seuprojeto.chamado.model.Usuario;
import com.seuprojeto.chamado.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));

        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getPerfil().name());
        return new User(usuario.getEmail(), usuario.getSenha(), List.of(authority));
    }


}