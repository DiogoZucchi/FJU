package controller;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.PessoaMidiaDao;
import model.PessoaMidia;

@ManagedBean(name="listarMB")
public class ListarMB {

	private List<PessoaMidia> pessoas;
	
	public ListarMB() {
		listarMidia();
	}

	//LISTAR TODOS OS MIDIAS.
	public void listarMidia() {
		pessoas = new LinkedList<PessoaMidia>();
		PessoaMidiaDao pessoaMidiaDao = new PessoaMidiaDao();
		pessoas = pessoaMidiaDao.listarTodos();
	}
	
	public List<PessoaMidia> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<PessoaMidia> pessoas) {
		this.pessoas = pessoas;
	}
}
