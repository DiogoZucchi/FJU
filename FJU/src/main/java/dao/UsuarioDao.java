package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;

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
		System.out.println("Entro1");
		manager = EntityManagerProvider.getEntityManagerFactory();
		System.out.println("Entro2");
		System.out.println("Entro3");
		try {

			System.out.println("Entro4");
			
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
			Root<Usuario> root = cq.from(Usuario.class);
			cq.select(root);
			
		    Path<String> login = root.get("login");
		    cq.where(cb.and(cb.equal(login, u.getLogin())));
		    
		    Path<String> password = root.get("password");
		    cq.where(cb.and(cb.equal(password, u.getPassword())));
			 
			TypedQuery<Usuario> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty()){
				System.out.println("NULA");
				return null;
			}else
				System.out.println("NÃO NULA");
				
			System.out.println("Entro5");
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
