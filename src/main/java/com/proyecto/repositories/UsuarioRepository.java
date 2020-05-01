package com.proyecto.repositories;

import java.util.List;

import com.proyecto.entities.Usuario;

public interface UsuarioRepository {

	public List<Usuario> findAll();

	public Usuario find(int id);

	public Usuario identificarse(String username, String password);

	public void create(Usuario usuario);

	public void update(Usuario usuario);

	public void delete(Usuario usuario);

}
