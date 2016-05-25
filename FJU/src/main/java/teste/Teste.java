package teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.CidadeDao;
import dao.EstadoDao;
import model.Bloco;
import model.Cidade;
import model.DadosEspirituais;
import model.Equipamento;
import model.Estado;
import model.Idioma;
import model.PessoaMidia;

public class Teste {
	public static void main(String[] args) {
		//ESCOPOS DO MANAGEDBEAN
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		
//		manager.getTransaction().begin();
//		SessionFactory fabrica = new Configuration().configure().buildSessionFactory();
//		Session sessao = fabrica.openSession();
//		Transaction txAluno = sessao.beginTransaction();
		
		
		//***********************************************************************
		//           			 ESTADO / BLOCO / CIDADE
		//***********************************************************************
				
		//INSERIR ESTADO.
		Estado estado = new Estado();
		estado.setNome("Santa Catarina");
		estado.setUf("SC");
		manager.persist(estado);
		//INSERIR BLOCO.
		Bloco bloco = new Bloco();
		bloco.setEstado(estado);
		bloco.setNome("Bloco Blumenau");
		manager.persist(bloco);
		//INSERIR CIDADE.
		Cidade cidade = new Cidade();
		cidade.setBloco(bloco);
		cidade.setEstado(estado);
		cidade.setNome("Blumenau");
		manager.persist(cidade);
		
		/*
		//LISTAR UM ESTADO.
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.listarUm("SC"); 
		System.out.println(estado.toString());
		*//*
		//LISTAR UMA CIDADE.
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.listarUm("Blumenau", estado);
		System.out.println(cidade.toString());
		*/
		//***********************************************************************
		
		//***********************************************************************
		//				   DADOS ESPIRITUAIS / IDIOMA / EQUIPAMENTO
		//***********************************************************************
		DadosEspirituais de = new DadosEspirituais();
		de.setDtBatismo(new Date());
		de.setDtEspiritoSanto(new Date());
		de.setDtInicioFJU(new Date());
		de.setDtInicioUniversal(new Date());
		de.setObreiro(true);
		manager.persist(de);
		
		LinkedList<Idioma> idiomas = new LinkedList<Idioma>();
		Idioma idioma = new Idioma();
		idioma.setDescricao("Alemon");
		idioma.setNivel(2);
		manager.persist(idioma);
		idiomas.add(idioma);
		
		LinkedList<Equipamento> equipamentos = new LinkedList<Equipamento>();
		Equipamento equi = new Equipamento();
		equi.setDescricao("Camera");
		manager.persist(equi);
		equipamentos.add(equi);
		
		//***********************************************************************
		//								PESSOA MIDIA
		//***********************************************************************
		PessoaMidia pessoaMidia = new PessoaMidia();
		pessoaMidia.setNome("Diogo");
		pessoaMidia.setDepartamento(1);
		pessoaMidia.setEstado(estado);
		pessoaMidia.setBloco(bloco);
		pessoaMidia.setCidade(cidade);
		pessoaMidia.setDadosEspirituais(de);
		pessoaMidia.setEquipamentos(equipamentos);
		pessoaMidia.setIdiomas(idiomas);
		manager.persist(pessoaMidia);
		//***********************************************************************
		
		manager.getTransaction().commit();
		manager.close();
	}
}
