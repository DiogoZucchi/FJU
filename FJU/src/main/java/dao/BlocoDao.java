package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import model.Bloco;

public class BlocoDao {
	
	private EntityManager manager;
	
	public void inserir(Bloco bloco) {
		manager = EntityManagerProvider.getEntityManagerFactory();
	
		try {
			manager.getTransaction().begin();
			manager.persist(bloco);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(Bloco bloco){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(bloco);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(Bloco bloco) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(bloco);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public Bloco listarUm(int codigo) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Bloco> cq = cb.createQuery(Bloco.class);
			Root<Bloco> root = cq.from(Bloco.class);
			cq.select(root);
			
		    Path<String> restricaoCodigo = root.get("codigo");
		    cq.where(cb.and(cb.equal(restricaoCodigo, codigo)));
		    
			TypedQuery<Bloco> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty())
				return null;
			return query.getResultList().get(0);
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<Bloco> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Bloco> cq = cb.createQuery(Bloco.class);
			Root<Bloco> root = cq.from(Bloco.class);
			cq.select(root);
			
			TypedQuery<Bloco> query = manager.createQuery(cq);
			
			return (ArrayList<Bloco>) query.getResultList();
		} finally {
			manager.close();
		}
	}
}
