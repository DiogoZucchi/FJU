package controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.SelectEvent;

import dao.BlocoDao;
import dao.CidadeDao;
import dao.EstadoDao;
import model.Bloco;
import model.Cidade;
import model.Estado;

@ManagedBean(name="blocoMB")
@SessionScoped
public class BlocoMB {
	private String cidadeRemoverDaLista;
	private Bloco bloco;
	private Estado estado;
	private List<Bloco> blocos; 
	private List<String> cidades = new LinkedList<String>();
	private Map<Integer, String> blocoMap;
	static String blocoSelected;
	
	public BlocoMB() {
		bloco = new Bloco();
		estado = new Estado();
		listarBlocos();
	}
	
	public void popularBlocoMap() {
		blocoMap = new HashMap<Integer, String>();
		BlocoDao blocoDao = new BlocoDao();
		try{
			for (Bloco b : blocoDao.listarTodos()) {
				if(b.getEstado().getUf().equals(EstadoMB.estadoSelected))
					blocoMap.put(b.getCodigo(), b.getNome());
			}
			Map.Entry<Integer, String> someEntry = blocoMap.entrySet().iterator().next();
			blocoSelected = someEntry.getValue();
		}catch(Exception e){
			System.out.println("ESTADO NÃO SELECIONADO!\n"+e);
		}
	}
	
	//UTILIZADO EM bloco.xhtml
	public void listarBlocos() {
		blocos = new LinkedList<Bloco>();
		BlocoDao blocoDao = new BlocoDao();
		blocos = blocoDao.listarTodos();
	}
	//UTILIZADO EM bloco.xhtml	
	public void inserirListaCidades() {
		CidadeDao cidadeDao = new CidadeDao();
		EstadoDao estadoDao = new EstadoDao();
		
		Cidade c = cidadeDao.listarUm(CidadeMB.cidadeSelected, estadoDao.listarUm(EstadoMB.estadoSelected));
		cidades.add(c.getNome());
	}
	//UTILIZADO EM bloco.xhtml	
	public void onSelect(SelectEvent event) {
		cidadeRemoverDaLista = event.getObject().toString();
    }
	//UTILIZADO EM bloco.xhtml
	public void removerListaCidades() {
		cidades.remove(cidadeRemoverDaLista);
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
	public List<Bloco> getBlocos() {
		return blocos;
	}
	public void setBlocos(List<Bloco> blocos) {
		this.blocos = blocos;
	}
	public List<String> getCidades() {
		return cidades;
	}
	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}
	public String getBlocoSelected() {
		return blocoSelected;
	}
	public void setBlocoSelected(String blocoSelected) {
		BlocoMB.blocoSelected = blocoSelected;
	}
}
