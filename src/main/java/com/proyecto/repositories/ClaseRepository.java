package com.proyecto.repositories;

import java.util.List;

import com.proyecto.entities.Clase;

public interface ClaseRepository {

	public List<Clase> findAll();

	public Clase find(int id);

	public void create(Clase clase);

	public void update(Clase clase);

	public void delete(Clase clase);
}
