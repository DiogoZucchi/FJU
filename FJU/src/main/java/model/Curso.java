package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="descricao")
	private String descrição;
	
	@Column(name="mesesDuracao")
	private int mesesDuracao;

	//GET - SET.
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	public int getMesesDuracao() {
		return mesesDuracao;
	}
	public void setMesesDuracao(int mesesDuracao) {
		this.mesesDuracao = mesesDuracao;
	}
}
