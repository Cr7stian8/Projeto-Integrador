package com.generation.casaDasMudas.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.generation.casaDasMudas.model.Usuario;
import com.generation.casaDasMudas.model.UsuarioLogin;
import com.generation.casaDasMudas.repository.UsuarioRepository;

@Service

public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario cadastrarUsuario(Usuario oUsuario) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); //criptografar senha
		
		String senhaEncoder = encoder.encode(oUsuario.getSenhaUsuario()); //criptografando
		oUsuario.setSenhaUsuario(senhaEncoder); //enviando ao banco de dados
		
		return repository.save(oUsuario);
	}
	
	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> oUser){
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> oUsuario  = repository.findByEmailUsuario(oUser.get().getUsuarioLogin());
		
		if(oUsuario.isPresent()) {
			if(encoder.matches(oUser.get().getSenhaLogin(), oUsuario.get().getSenhaUsuario())) { 	// comparando senhas, a que pega no 
																									//banco de dados e a que o usuário digita
				
				String auth = oUser.get().getUsuarioLogin() + ":" + oUser.get().getSenhaLogin();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String (encodedAuth);
				
				oUser.get().setTokenLogin(authHeader);
				oUser.get().setNomeLogin(oUsuario.get().getEmailUsuario());
				
				return oUser;
			}
		}
		return null;
	}
}
