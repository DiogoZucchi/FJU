package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import model.Idioma;

public class IdiomaDao {
private EntityManager manager;
	
	public void inserir(Idioma idioma) {
		manager = EntityManagerProvider.getEntityManagerFactory();
	
		try {
			manager.getTransaction().begin();
			manager.persist(idioma);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(Idioma idioma){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(idioma);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(Idioma idioma) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(idioma);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public Idioma listarUm(int codigo) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Idioma> cq = cb.createQuery(Idioma.class);
			Root<Idioma> root = cq.from(Idioma.class);
			cq.select(root);
			
		    Path<String> restricaoCodigo = root.get("codigo");
		    cq.where(cb.and(cb.equal(restricaoCodigo, codigo)));
		    
			TypedQuery<Idioma> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty())
				return null;
			return query.getResultList().get(0);
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<Idioma> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Idioma> cq = cb.createQuery(Idioma.class);
			Root<Idioma> root = cq.from(Idioma.class);
			cq.select(root);
			
			TypedQuery<Idioma> query = manager.createQuery(cq);
			
			return (ArrayList<Idioma>) query.getResultList();
		} finally {
			manager.close();
		}
	}
}

