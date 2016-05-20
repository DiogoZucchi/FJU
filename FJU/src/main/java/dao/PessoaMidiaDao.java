package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	public PessoaMidia listarUm(int id) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		try {
			return manager.find(PessoaMidia.class, id);
		}catch(Exception e){
			return null;
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<PessoaMidia> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			TypedQuery<PessoaMidia> consulta = manager.createQuery("SELECT id,login,password FROM PessoaMidia", PessoaMidia.class);
			return (ArrayList<PessoaMidia>) consulta.getResultList();
		} finally {
			manager.close();
		}
	}
}
