package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import model.PessoaMidia;


public class PessoaMidiaDao {
	private EntityManager manager;
	
	public void inserir(PessoaMidia pessoa) {
		manager = EntityManagerProvider.getEntityManagerFactory();
	
		try {
			manager.getTransaction().begin();
			manager.persist(pessoa);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(PessoaMidia pessoa){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(pessoa);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(PessoaMidia pessoa) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(pessoa);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public PessoaMidia listarUm(int codigo) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<PessoaMidia> cq = cb.createQuery(PessoaMidia.class);
			Root<PessoaMidia> root = cq.from(PessoaMidia.class);
			cq.select(root);
			
		    Path<String> restricaoCodigo = root.get("codigo");
		    cq.where(cb.and(cb.equal(restricaoCodigo, codigo)));
		    
			TypedQuery<PessoaMidia> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty())
				return null;
			return query.getResultList().get(0);
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<PessoaMidia> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<PessoaMidia> cq = cb.createQuery(PessoaMidia.class);
			Root<PessoaMidia> root = cq.from(PessoaMidia.class);
			cq.select(root);
			
			TypedQuery<PessoaMidia> query = manager.createQuery(cq);
			
			return (ArrayList<PessoaMidia>) query.getResultList();
		} finally {
			manager.close();
		}
	}
}
