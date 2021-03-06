package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

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
	
	public Usuario listarUm(Usuario u) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {

			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
			Root<Usuario> root = cq.from(Usuario.class);
			cq.select(root);
			
		    Path<String> login = root.get("login");
		    cq.where(cb.and(cb.equal(login, u.getLogin())));
		    
		    Path<String> password = root.get("password");
		    cq.where(cb.and(cb.equal(password, u.getPassword())));
			 
			TypedQuery<Usuario> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty())
				return null;
			else
				return query.getResultList().get(0);
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<Usuario> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
			Root<Usuario> root = cq.from(Usuario.class);
			cq.select(root);
			
			TypedQuery<Usuario> query = manager.createQuery(cq);
			
			return (ArrayList<Usuario>) query.getResultList();
		} finally {
			manager.close();
		}
	}
}
