package com.proyecto.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.proyecto.entities.Alumno;

public class AlumnoRepositoryImpl implements AlumnoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		try {
			return entityManager.createQuery("from Alumno").getResultList();
		}catch(Exception e) {
			return null;
		}
	}

	public Alumno find(int id) {
		// TODO Auto-generated method stub
		try {
			return (Alumno) entityManager.createQuery("from Alumno where id = :id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}

	public void create(Alumno alumno) {
		// TODO Auto-generated method stub
		entityManager.persist(alumno);
	}

	public void update(Alumno alumno) {
		// TODO Auto-generated method stub
		entityManager.merge(alumno);
	}

	public void delete(Alumno alumno) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(alumno));
	}
}
