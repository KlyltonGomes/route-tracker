package com.routetracker.service;

import com.routetracker.domain.entity.Usuario;
import com.routetracker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }


}
