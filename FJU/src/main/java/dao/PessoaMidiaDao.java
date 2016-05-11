package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class PessoaMidiaDao {
	private EntityManager manager;
	
	public void inserir(PessoaMidiaDao pessoa) {
		manager = EntityManagerProvider.getEntityManagerFactory();
	
		try {
			manager.getTransaction().begin();
			manager.persist(pessoa);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	public void remover(PessoaMidiaDao pessoa){
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.remove(pessoa);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}	
	}
	
	public void alterar(PessoaMidiaDao pessoa) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			manager.getTransaction().begin();
			manager.merge(pessoa);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}
	}
	
	/*public PessoaMidiaDao listarUm(PessoaMidiaDao u) {
		manager = EntityManagerProvider.getEntityManagerFactory();
		ArrayList<PessoaMidiaDao> PessoaMidiaDaos = new ArrayList<PessoaMidiaDao>();
		try {
			PessoaMidiaDaos = listarTodos();
			for (PessoaMidiaDao PessoaMidiaDao : PessoaMidiaDaos) {
				if((PessoaMidiaDao.getLogin().equalsIgnoreCase(u.getLogin())) && (PessoaMidiaDao.getPassword().equalsIgnoreCase(u.getPassword()))){
					System.out.println("Ee");
					return PessoaMidiaDao;
				}
			}
			return null;
		} finally {
			manager.close();
		}
	}*/
	
	public ArrayList<PessoaMidiaDao> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			TypedQuery<PessoaMidiaDao> consulta = manager.createQuery("SELECT id,login,password FROM PessoaMidiaDao", PessoaMidiaDao.class);
			return (ArrayList<PessoaMidiaDao>) consulta.getResultList();
		} finally {
			manager.close();
		}
	}
}
