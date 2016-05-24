package controller;

import java.util.LinkedHashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.CidadeDao;
import dao.EstadoDao;
import model.Cidade;

@ManagedBean(name="cidadeMB")
@SessionScoped
public class CidadeMB {
	
	static String estadoSelected;
	private LinkedHashMap<String, String> cidadeMap;
	
	public void popularCidadeMap() {
		cidadeMap = new LinkedHashMap<String, String>();
		EstadoDao estadoDao = new EstadoDao(); 
		CidadeDao cidadeDao = new CidadeDao();
		
		try{
			for (Cidade c : cidadeDao.listarTodos(estadoDao.listarUm(estadoSelected))) {
				cidadeMap.put(c.getNome(), c.getNome());
			}
		}catch(Exception e){
			System.out.println("ESTADO NÃO SELECIONADO!\n"+e);
		}
	}

	public LinkedHashMap<String, String> getCidadeMap() {
		return cidadeMap;
	}
	public void setCidadeMap(LinkedHashMap<String, String> cidadeMap) {
		this.cidadeMap = cidadeMap;
	}
}
