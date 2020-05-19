package com.proyecto.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.proyecto.entities.Clase;
import com.proyecto.entities.Tarea;

public class ClaseRepositoryImpl implements ClaseRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Clase> findAll() {
		// TODO Auto-generated method stub
		try {
			return entityManager.createQuery("from Clase").getResultList();
		}catch(Exception e) {
			return null;
		}
	}

	public Clase find(int id) {
		// TODO Auto-generated method stub
		try {
			return (Clase) entityManager.createQuery("from Clase where idClase = :id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}

	public void create(Clase clase) {
		// TODO Auto-generated method stub
		entityManager.persist(clase);
	}

	public void update(Clase clase) {
		// TODO Auto-generated method stub
		entityManager.merge(clase);
	}

	public void delete(Clase clase) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(clase));
	}
}
