package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.entities.Clase;
import com.proyecto.repositories.ClaseRepository;

@Transactional
public class ClaseServiceImpl implements ClaseService{
	
	@Autowired
	private ClaseRepository claseRepository;
	
	public ClaseServiceImpl(ClaseRepository claseRepository) {
		super();
		this.claseRepository = claseRepository;
	}

	public List<Clase> findAll() {
		// TODO Auto-generated method stub
		return this.claseRepository.findAll();
	}

	public Clase find(int idClase) {
		// TODO Auto-generated method stub
		return this.claseRepository.find(idClase);
	}

	public void create(Clase clase) {
		// TODO Auto-generated method stub
		this.claseRepository.create(clase);
	}

	public void update(Clase clase) {
		// TODO Auto-generated method stub
		this.claseRepository.update(clase);
	}

	public void delete(Clase clase) {
		// TODO Auto-generated method stub
		this.claseRepository.delete(clase);
	}
}
