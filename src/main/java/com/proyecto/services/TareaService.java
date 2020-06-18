package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Tarea;

public interface TareaService {

	public List<Tarea> findAll(int id_usuario);

	public Tarea find(int id);

	public void create(Tarea tarea);

	public void update(Tarea tarea);

	public void delete(Tarea tarea);
	
	public Tarea imagen(int id);
	public List<Tarea> findPrioritarios(int id_usuario);
}
