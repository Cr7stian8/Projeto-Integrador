package com.generation.casaDasMudas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.casaDasMudas.model.Usuario;
import com.generation.casaDasMudas.repository.UsuarioRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> buscarId(@PathVariable Long idUsuario){
		return repository.findById(idUsuario)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeusuario/{nomeUsuario}")
	public ResponseEntity<List<Usuario>> buscarNome(@PathVariable String nomeUsuario){
		return ResponseEntity.ok(repository.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario oUsuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(oUsuario));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> alterar(@Valid @RequestBody Usuario oUsuario){
		return ResponseEntity.ok(repository.save(oUsuario));
	}
	
	@DeleteMapping("/{idUsuario}")
	public void deletar(@PathVariable Long idUsuario) {
		repository.deleteById(idUsuario);
	}
}
