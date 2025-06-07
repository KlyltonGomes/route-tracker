package com.routetracker.repositoryTest;

import com.routetracker.domain.entity.Usuario;
import com.routetracker.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testFindByEmail(){
        // Suponha que já tenha um usuário salvo no banco de teste
        Optional<Usuario> userOpt = usuarioRepository.findByEmail("teste@email.com");

        Assertions.assertTrue(userOpt.isPresent());
        Assertions.assertEquals("teste@email.com", userOpt.get().getEmail());
    }


}
