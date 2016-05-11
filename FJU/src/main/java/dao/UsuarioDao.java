package dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			usuarios = listarTodos();
			for (Usuario usuario : usuarios) {
				if((usuario.getLogin().equalsIgnoreCase(u.getLogin())) && (usuario.getPassword().equalsIgnoreCase(u.getPassword()))){
					System.out.println("Ee");
					return usuario;
				}
			}
			return null;
		} finally {
			manager.close();
		}
	}
	
	public ArrayList<Usuario> listarTodos() {
		manager = EntityManagerProvider.getEntityManagerFactory();
		
		try {
			TypedQuery<Usuario> consulta = manager.createQuery("SELECT id,login,password FROM Usuario", Usuario.class);
			return (ArrayList<Usuario>) consulta.getResultList();
		} finally {
			manager.close();
		}
	}
}
