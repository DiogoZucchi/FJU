package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import model.Cidade;
import model.Estado;

public class CidadeDao {
	
	private EntityManager manager;
	
	public void inserir(Cidade cidade) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.persist(cidade);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(Cidade cidade){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(cidade);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(Cidade cidade) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(cidade);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public Cidade listarUm(String nome, Estado estado) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Cidade> cq = cb.createQuery(Cidade.class);
			Root<Cidade> root = cq.from(Cidade.class);
			cq.select(root);
			
		    Path<String> restricaoNome = root.get("nome");
		    Path<String> restricaoUF = root.get("estado");
		    
		    cq.where(cb.and(cb.equal(restricaoNome, nome)),cb.and(cb.equal(restricaoUF, estado)));

		    TypedQuery<Cidade> query = manager.createQuery(cq);
			
			if(query.getResultList().isEmpty())
				return null;
			
			return query.getResultList().get(0);
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<Cidade> listarTodos(Estado estado) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Cidade> cq = cb.createQuery(Cidade.class);
			Root<Cidade> root = cq.from(Cidade.class);
			cq.select(root);
			
		    Path<String> restricaoUF = root.get("estado");
		    cq.where(cb.and(cb.equal(restricaoUF, estado)));
			
			TypedQuery<Cidade> query = manager.createQuery(cq);
			
			return (ArrayList<Cidade>) query.getResultList();
		} finally {
			manager.close();
		}
	}
}
