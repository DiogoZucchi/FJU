package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import model.Formacao;

public class FormacaoDao {
private EntityManager manager;
	
	public void inserir(Formacao formacao) {
		manager = EntityManagerProvider.getEntityManagerFactory();
	
		try {
			manager.getTransaction().begin();
			manager.persist(formacao);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(Formacao formacao){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(formacao);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(Formacao formacao) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(formacao);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public Formacao listarUm(int codigo) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Formacao> cq = cb.createQuery(Formacao.class);
			Root<Formacao> root = cq.from(Formacao.class);
			cq.select(root);
			
		    Path<String> restricaoCodigo = root.get("codigo");
		    cq.where(cb.and(cb.equal(restricaoCodigo, codigo)));
		    
			TypedQuery<Formacao> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty())
				return null;
			return query.getResultList().get(0);
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<Formacao> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Formacao> cq = cb.createQuery(Formacao.class);
			Root<Formacao> root = cq.from(Formacao.class);
			cq.select(root);
			
			TypedQuery<Formacao> query = manager.createQuery(cq);
			
			return (ArrayList<Formacao>) query.getResultList();
		} finally {
			manager.close();
		}
	}
}
