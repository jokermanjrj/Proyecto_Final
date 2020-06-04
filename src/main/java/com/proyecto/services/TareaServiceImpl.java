package com.proyecto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.entities.Tarea;
import com.proyecto.repositories.TareaRepository;

@Transactional //necesario para crear datos
public class TareaServiceImpl implements TareaService{

	@Autowired
	private TareaRepository tareaRepository;

	public TareaServiceImpl(TareaRepository tareaRepository) {
		this.tareaRepository = tareaRepository;
	}

	public List<Tarea> findAll(int id_usuario) {
		return this.tareaRepository.findAll(id_usuario);
	}

	public Tarea find(int id) {
		// TODO Auto-generated method stub
		return this.tareaRepository.find(id);
	}

	public void create(Tarea tarea) {
		// TODO Auto-generated method stub
		this.tareaRepository.create(tarea);
		
	}

	public void update(Tarea tarea) {
		// TODO Auto-generated method stub
		this.tareaRepository.update(tarea);
		
	}

	public void delete(Tarea tarea) {
		// TODO Auto-generated method stub
		this.tareaRepository.delete(tarea);
		
	}

	public Tarea imagen(int id) {
		// TODO Auto-generated method stub
		return this.tareaRepository.imagen(id);
	}
}
