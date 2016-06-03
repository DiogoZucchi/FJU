package controller;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.CidadeDao;
import dao.EstadoDao;
import model.Cidade;

@ManagedBean(name="cidadeMB")
@SessionScoped
public class CidadeMB {
	
	private HashMap<String, String> cidadeMap;
	static String cidadeSelected;
	
	public void popularCidadeMap() {
		cidadeMap = new HashMap<String, String>();
		EstadoDao estadoDao = new EstadoDao(); 
		CidadeDao cidadeDao = new CidadeDao();
		
		try{
			for (Cidade c : cidadeDao.listarTodos(estadoDao.listarUm(EstadoMB.estadoSelected))) {
				cidadeMap.put(c.getNome(), c.getNome());
			}
			Map.Entry<String, String> someEntry = cidadeMap.entrySet().iterator().next();
			cidadeSelected = someEntry.getValue();
		}catch(Exception e){
			System.out.println("ESTADO NÃO SELECIONADO!\n"+e);
		}
	}

	public HashMap<String, String> getCidadeMap() {
		return cidadeMap;
	}
	public void setCidadeMap(HashMap<String, String> cidadeMap) {
		this.cidadeMap = cidadeMap;
	}

	public String getCidadeSelected() {
		return cidadeSelected;
	}
	public void setCidadeSelected(String cidadeSelected) {
		CidadeMB.cidadeSelected = cidadeSelected;
	}
}
