package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
	
	@Id
	private String uf;

	private String nome;
	
	//GET - SET.
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Estado [uf=" + uf + ", nome=" + nome + "]";
	}
}
