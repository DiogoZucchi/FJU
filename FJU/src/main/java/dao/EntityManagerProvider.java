package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
	
	private static EntityManagerFactory emf = null;

	private EntityManagerProvider() {}

	public static EntityManager getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("teste");
		}
		return emf.createEntityManager();
	}
}
