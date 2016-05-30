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
	private int curso;
	private int grauEscolaridade;
	private int EscolaSituacao;
	private int SuperiorSituacao;
	
	//GET - SET.
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getGrauEscolaridade() {
		return grauEscolaridade;
	}
	public void setGrauEscolaridade(int grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}
	public int getEscolaSituacao() {
		return EscolaSituacao;
	}
	public void setEscolaSituacao(int escolaSituacao) {
		EscolaSituacao = escolaSituacao;
	}
	public int getSuperiorSituacao() {
		return SuperiorSituacao;
	}
	public void setSuperiorSituacao(int superiorSituacao) {
		SuperiorSituacao = superiorSituacao;
	}
}
