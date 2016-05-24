package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.BlocoDao;
import model.Bloco;
import model.Estado;

@ManagedBean(name="blocoMB")
@SessionScoped
public class BlocoMB {
	private Bloco bloco;
	private Estado estado;
	static String estadoSelected;
	public Map<Integer, String> blocoMap;
	
	public BlocoMB() {
		bloco = new Bloco();
		estado = new Estado();
	}
	
	public void popularBlocoMap() {
		blocoMap = new LinkedHashMap<Integer, String>();
		BlocoDao blocoDao = new BlocoDao();
		try{
			for (Bloco b : blocoDao.listarTodos()) {
				if(b.getEstado().getUf().equals(estadoSelected))
					blocoMap.put(b.getCodigo(), b.getNome());
			}
		}catch(Exception e){
			System.out.println("ESTADO NÃO SELECIONADO!\n"+e);
		}
	}
	
	public Bloco getBloco() {
		return bloco;
	}
	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Map<Integer, String> getBlocoMap() {
		return blocoMap;
	}
	public void setBlocoMap(Map<Integer, String> blocoMap) {
		this.blocoMap = blocoMap;
	}
}
