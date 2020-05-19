package com.proyecto.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.entities.Alumno;
import com.proyecto.repositories.AlumnoRepository;

@Transactional //necesario para crear datos
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	public List<Alumno> findAll() {
		return this.alumnoRepository.findAll();
	}

	public Alumno find(int id) {
		// TODO Auto-generated method stub
		return this.alumnoRepository.find(id);
	}

	public void create(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepository.create(alumno);
		
	}

	public void update(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepository.update(alumno);
		
	}

	public void delete(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepository.delete(alumno);
		
	}

}
