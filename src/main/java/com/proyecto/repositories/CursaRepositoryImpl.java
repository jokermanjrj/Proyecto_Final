package com.proyecto.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.proyecto.entities.Cursa;

public class CursaRepositoryImpl implements CursaRepository{
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Cursa> findAll(int clase_id) {
		// TODO Auto-generated method stub
		try {
			return entityManager.createQuery("from Cursa where clase_id =:clase_id").setParameter("clase_id", clase_id).getResultList();
		}catch(Exception e) {
			return null;
		}
	}

}
