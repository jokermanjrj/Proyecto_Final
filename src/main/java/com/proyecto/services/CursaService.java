package com.proyecto.services;

import java.util.List;

import com.proyecto.entities.Cursa;

public interface CursaService {

	public List<Cursa> findAll(int clase_id);
}
