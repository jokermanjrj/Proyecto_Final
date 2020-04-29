package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Tarea;

public interface TareaService {

	public List<Tarea> findAll();

	public Tarea find(int id);

	public void create(Tarea tarea);

	public void update(Tarea tarea);

	public void delete(Tarea tarea);
}
