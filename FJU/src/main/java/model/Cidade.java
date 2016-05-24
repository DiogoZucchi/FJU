package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="bloco_id")
	private Bloco bloco;
	
	@ManyToOne
	@JoinColumn(name="estado_id")
	private Estado estado;

	//GET / SET
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", nome=" + nome + ", bloco=" + bloco + ", estado=" + estado + "]";
	}
}
