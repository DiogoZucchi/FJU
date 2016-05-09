package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Usuario;

public class UsuarioDao {
	private EntityManager manager;
	
	public void inserir(Usuario usuario) {
		manager = EntityManagerProvider.getEntityManagerFactory();
	
		try {
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(Usuario usuario){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(usuario);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(Usuario usuario) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(usuario);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public Usuario listarUm(long id) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			Usuario user = manager.find(Usuario.class, id);
			return user;
		} finally {
			manager.close();
		}
	}
	
	public Collection<Usuario> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			Query query = manager.createQuery("SELECT * FROM usuario");
			return query.getResultList();
		} finally {
			manager.close();
		}
	}
}
