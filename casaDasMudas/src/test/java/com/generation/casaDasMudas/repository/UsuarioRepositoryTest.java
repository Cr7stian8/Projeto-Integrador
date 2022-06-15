package com.generation.casaDasMudas.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.casaDasMudas.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		usuarioRepository.save(
				new Usuario(0L, "João da Silva", "joao@email.com.br", "13465278", "https://i.imgur.com/FETvs2O.jpg"));
		usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "manuela@email.com.br", "13465278",
				"https://i.imgur.com/NtyGneo.jpg"));
		usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "adriana@email.com.br", "13465278",
				"https://i.imgur.com/mB3VM2N.jpg"));
		usuarioRepository.save(
				new Usuario(0L, "Paulo Antunes", "paulo@email.com.br", "13465278", "https://i.imgur.com/JR7kUFU.jpg"));
	}

	@Test
	@DisplayName("Retorna 1 usuário")
	public void deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByEmailUsuario("joao@email.com.br");
		assertTrue(usuario.get().getEmailUsuario().equals("joao@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuários")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeUsuarioContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNomeUsuario().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(0).getNomeUsuario().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(0).getNomeUsuario().equals("Adriana da Silva"));
	}

	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
}
