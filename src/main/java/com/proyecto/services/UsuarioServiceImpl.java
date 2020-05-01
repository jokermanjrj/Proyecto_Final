package com.proyecto.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.proyecto.entities.Usuario;
import com.proyecto.repositories.UsuarioRepository;

@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository usuarioRepository;
	
	
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll();
	}

	public Usuario find(int id) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.find(id);
	}

	public Usuario identificarse(String username, String password) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.identificarse(username, password);
	}

	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuarioRepository.create(usuario);
		
	}

	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuarioRepository.update(usuario);
		
	}

	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		this.usuarioRepository.delete(usuario);
		
	}

}
