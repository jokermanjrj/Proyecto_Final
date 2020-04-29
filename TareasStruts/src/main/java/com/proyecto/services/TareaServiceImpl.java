package com.proyecto.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.proyecto.entities.Tarea;
import com.proyecto.repositories.TareaRepository;

@Transactional //necesario para crear datos
public class TareaServiceImpl implements TareaService{

	private TareaRepository tareaRepository;

	public TareaServiceImpl(TareaRepository tareaRepository) {
		this.tareaRepository = tareaRepository;
	}

	public List<Tarea> findAll() {
		return this.tareaRepository.findAll();
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
}
