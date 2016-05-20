package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import model.Estado;

public class EstadoDao {
	
	private EntityManager manager;
	
	public void inserir(Estado estado) {
		manager = EntityManagerProvider.getEntityManagerFactory();
	
		try {
			manager.getTransaction().begin();
			manager.persist(estado);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(Estado estado){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(estado);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(Estado estado) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(estado);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public Estado listarUm(String uf) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Estado> cq = cb.createQuery(Estado.class);
			Root<Estado> root = cq.from(Estado.class);
			cq.select(root);
			
		    Path<String> restricaoUF = root.get("uf");
		    cq.where(cb.and(cb.equal(restricaoUF, uf)));
		    
			TypedQuery<Estado> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty())
				return null;
			return query.getResultList().get(0);
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<Estado> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Estado> cq = cb.createQuery(Estado.class);
			Root<Estado> root = cq.from(Estado.class);
			cq.select(root);
			
			TypedQuery<Estado> query = manager.createQuery(cq);
			
			return (ArrayList<Estado>) query.getResultList();
		} finally {
			manager.close();
		}
	}
}
