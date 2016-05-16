package model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {
	private String uf;
	private String nome;
	private ArrayList<Bloco> listaBloco = new ArrayList<Bloco>();
	
	
	@Id
	@Column(name="uf")
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Bloco> getListaBloco() {
		return listaBloco;
	}
	public void setListaBloco(ArrayList<Bloco> listaBloco) {
		this.listaBloco = listaBloco;
	}
	
}
