package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	private String grauEscolaridade;
	private String situacao;
	private String faseAtual;
	
	//GET - SET.
	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}
	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getFaseAtual() {
		return faseAtual;
	}
	public void setFaseAtual(String faseAtual) {
		this.faseAtual = faseAtual;
	}
}
