package com.softnar.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softnar.app.model.Usuario;
import com.softnar.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuarioService {
	
	@Autowired
	private UsuariosRepository usuariosRepo;
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
		
	}

}
