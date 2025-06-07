package com.routetracker;

import com.routetracker.domain.entity.Acesso;
import com.routetracker.domain.entity.Motorista;
import com.routetracker.domain.entity.Usuario;
import com.routetracker.domain.enums.*;
import com.routetracker.repository.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;


import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
/*
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
para usar postgres como bd de teste real
 */
//@ActiveProfiles("test")
@SpringBootTest
@Transactional
@Commit
class RouteTrackerApplicationTests {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private MotoristaRepository motoristaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AcessoRepositoy acessoRepositoy;


	@Test
	void testeRelacionamento() {


		Motorista m = new Motorista();
		m.setNome("joao");
		m.setStatus(StatusPessoa.ATIVO);
		m.setTipoPessoa(TipoPessoa.MOTORISTA);
		m.setDataCriacao(LocalDateTime.now());
		m.setNumeroDocumento("12345678");
		m.setTelefone("1122334455");
		m.setAtivo(true);
		m.setTipoDocumento(TipoDocumento.CPF);
		m.setPlaca("ABC-123");
		m.setVeiculo(TipoVeiculo.CARRO);


		Acesso a = new Acesso();
		a.setDescricao(Role.ROLE_MOTORISTA);
		a = acessoRepositoy.save(a);

		Usuario u = new Usuario();
		u.setEmail("joao@.com");
		u.setSenha(passwordEncoder.encode("123"));
		u.setPessoa(m);
		u.setAcessos(List.of(a));
		u = usuarioRepository.save(u);



		m = pessoaRepository.save(m);

	}
}

