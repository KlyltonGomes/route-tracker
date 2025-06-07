package com.routetracker;

import com.routetracker.domain.entity.Acesso;
import com.routetracker.domain.entity.Usuario;
import com.routetracker.domain.enums.Role;
import com.routetracker.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class UsuarioTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    void deveSalvaUsuario(){

        // criar usuario

        Usuario user = new Usuario();
        user.setEmail("test@.com");
        user.setSenha(passwordEncoder.encode("senha123"));

        //relacionar usuario a um role
        Acesso role = new Acesso();
        role.setDescricao(Role.ROLE_MOTORISTA);

        //associar
        user.setAcessos(List.of(role));

/*
o usuário foi persistido com sucesso no banco de dados (e o ID foi gerado).
 */
        //Assertions.assertNotNull(user.getId());


    }

}
