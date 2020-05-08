package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();

	public Usuario find(int id);

	public List<Usuario> identificarse(String correo, String pasword);

	public void create(Usuario usuario);

	public void update(Usuario usuario);

	public void delete(Usuario usuario);

}
