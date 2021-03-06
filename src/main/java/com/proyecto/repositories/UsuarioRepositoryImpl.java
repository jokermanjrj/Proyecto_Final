package com.proyecto.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.proyecto.entities.Usuario;

public class UsuarioRepositoryImpl implements UsuarioRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		try {
			return entityManager.createQuery("from Usuario").getResultList();
		}catch(Exception e) {
			return null;
		}
	}

	public Usuario find(int id) {
		// TODO Auto-generated method stub
		try {
			return (Usuario) entityManager.createQuery("from Usuario where id = :id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {
			return null;
		}	}

	public void create(Usuario usuario) {
		// TODO Auto-generated method stub
		entityManager.persist(usuario);
		
	}

	public void update(Usuario usuario) {
		// TODO Auto-generated method stub
		entityManager.merge(usuario);
		
	}

	public void delete(Usuario usuario) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.merge(usuario));
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> identificarse(String correo, String pasword) {
		// TODO Auto-generated method stub
		try {
			return (List<Usuario>) entityManager.createQuery("from Usuario where correo = :correo and pasword = :pasword").setParameter("correo", correo).setParameter("pasword", pasword).getResultList();
			
		}catch(Exception e){
			return null;
		}
		
	}

}
