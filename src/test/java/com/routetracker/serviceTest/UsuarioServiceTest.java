package com.routetracker.serviceTest;

import com.routetracker.domain.entity.Usuario;
import com.routetracker.repository.UsuarioRepository;
import com.routetracker.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class UsuarioServiceTest {

    @Test
    public void testFindUserByEmail() {
        // Mock do repository
        UsuarioRepository usuarioRepository = Mockito.mock(UsuarioRepository.class);
        UsuarioService usuarioService = new UsuarioService();

        Usuario user = new Usuario();
        user.setEmail("teste@email.com");

        Mockito.when(usuarioRepository.findByEmail("teste@email.com"))
                .thenReturn(Optional.of(user));

        Optional<Usuario> result = usuarioService.findByEmail("teste@email.com");

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("teste@email.com", result.get().getEmail());
    }
}

