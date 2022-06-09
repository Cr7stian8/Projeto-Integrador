package com.generation.casaDasMudas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.casaDasMudas.model.Usuario;
import com.generation.casaDasMudas.repository.UsuarioRepository;

@Service

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
	}
}
