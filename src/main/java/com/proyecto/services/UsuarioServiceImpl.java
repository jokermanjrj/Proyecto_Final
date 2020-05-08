package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.entities.Usuario;
import com.proyecto.repositories.UsuarioRepository;

@Transactional
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
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

	public List<Usuario> identificarse(String correo, String pasword) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.identificarse(correo, pasword);
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
