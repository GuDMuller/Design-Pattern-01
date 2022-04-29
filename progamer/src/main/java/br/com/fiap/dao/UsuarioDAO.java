package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import br.com.fiap.model.Usuario;

public class UsuarioDAO {

	public void insert(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		manager.clear();
		
	}
	
	public List<Usuario> list(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u",Usuario.class);
		return query.getResultList();
		
	}
	
	
}
