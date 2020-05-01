package com.proyecto.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.proyecto.entities.Tarea;

public class TareaRepositoryImpl implements TareaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Tarea> findAll() {
		try {
			return entityManager.createQuery("from Tarea").getResultList();
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

}
