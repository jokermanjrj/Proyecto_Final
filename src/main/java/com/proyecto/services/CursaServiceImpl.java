package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.entities.Cursa;
import com.proyecto.repositories.CursaRepository;

public class CursaServiceImpl implements CursaService{

	@Autowired
	private CursaRepository cursaRepository;
	
	public CursaServiceImpl(CursaRepository cursaRepository) {
		super();
		this.cursaRepository = cursaRepository;
	}

	public List<Cursa> findAll(int clase_id) {
		// TODO Auto-generated method stub
		return this.cursaRepository.findAll(clase_id);
	}

}
