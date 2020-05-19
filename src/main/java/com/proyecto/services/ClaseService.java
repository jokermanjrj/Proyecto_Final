package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Clase;

public interface ClaseService {

	public List<Clase> findAll();

	public Clase find(int id);

	public void create(Clase clase);

	public void update(Clase clase);

	public void delete(Clase clase);
}
