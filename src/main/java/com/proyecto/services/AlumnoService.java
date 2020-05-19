package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Alumno;

public interface AlumnoService {
	
	public List<Alumno> findAll();

	public Alumno find(int id);

	public void create(Alumno clase);

	public void update(Alumno clase);

	public void delete(Alumno clase);
}
