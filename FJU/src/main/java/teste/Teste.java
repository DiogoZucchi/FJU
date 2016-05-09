package teste;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Aluno;
import model.Sala;

public class Teste {
	public static void main(String[] args) {
		//ESCOPOS DO MANAGEDBEAN
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager manager = factory.createEntityManager();
//		EntityTransaction trx = manager.getTransaction();
//		trx.begin();
		
		manager.getTransaction().begin();
		
		
		/*SessionFactory fabrica = new Configuration().configure().buildSessionFactory();
		Session sessao = fabrica.openSession();
		Transaction txAluno = sessao.beginTransaction();
		*/
		
		Aluno aluno = manager.find(Aluno.class, (long)2);
		System.out.println(aluno.getDescricao());
		manager.remove(aluno);
		
//		Sala sala = new Sala();
//		sala.setDescricao("Sala");
//		
//		Aluno aluno = new Aluno();
//		aluno.setDescricao("Rafael21");
//		aluno.setSala(sala);
//		
//		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
//		alunos.add(aluno);
//
//		sala.setAlunos(alunos);

//		manager.persist(sala);
		
		manager.getTransaction().commit();
		manager.close();
	}
}