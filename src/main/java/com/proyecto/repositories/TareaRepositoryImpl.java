package com.proyecto.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.proyecto.entities.Tarea;

public class TareaRepositoryImpl implements TareaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Tarea> findAll(int id_usuario) {
		try {
			return entityManager.createQuery("from Tarea where id_usuario = :id_usuario order by fecha").setParameter("id_usuario", id_usuario).getResultList();
		}catch(Exception e) {
			return null;
		}
	}

	public Tarea find(int id) {
		// TODO Auto-generated method stub
		try {
			return (Tarea) entityManager.createQuery("from Tarea where id = :id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}

	public void create(Tarea tarea) {
		// TODO Auto-generated method stub
		entityManager.persist(tarea);
		
	}

	public void update(Tarea tarea) {
		// TODO Auto-generated method stub
		entityManager.merge(tarea);
	}

	public void delete(Tarea tarea) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(tarea));
		
	}

	public Tarea imagen(int id) {
		// TODO Auto-generated method stub
		try {
			return (Tarea) entityManager.createQuery("from Tarea where id = :id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<Tarea> findPrioritarios(int id_usuario) {
		// TODO Auto-generated method stub
		try {
			return entityManager.createQuery("from Tarea where id_usuario = :id_usuario and prioridad=1 order by fecha").setParameter("id_usuario", id_usuario).getResultList();
		}catch(Exception e) {
			return null;
		}
	}


}
