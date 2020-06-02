package com.proyecto.repositories;

import java.util.List;

import com.proyecto.entities.Tarea;

public interface TareaRepository {
	
	public List<Tarea> findAll(int id_usuario);
	
	public Tarea find(int id);
	
	public void create(Tarea tarea);
	
	public void update(Tarea tarea);
	
	public void delete(Tarea tarea);
}
