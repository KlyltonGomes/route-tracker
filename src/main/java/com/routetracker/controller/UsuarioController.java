package com.routetracker.controller;

import com.routetracker.domain.entity.Usuario;
import com.routetracker.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/admin")
    public ResponseEntity<Usuario> saveUser(@RequestBody Usuario usuario) {
        // Aqui você pode salvar ou buscar por email
        Optional<Usuario> existente = usuarioService.findByEmail(usuario.getEmail());

        if (existente.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
}

