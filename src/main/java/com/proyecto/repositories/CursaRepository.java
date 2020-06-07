package com.proyecto.repositories;

import java.util.List;

import com.proyecto.entities.Cursa;

public interface CursaRepository {
	
	public List<Cursa> findAll(int id);

}
