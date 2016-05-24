package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bloco")
public class Bloco {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="estado_uf")
	private Estado estado;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="bloco")
	private List<Cidade> cidades;
	
	//CONSTRUTOR.
	public Bloco() {
		estado = new Estado();
		cidades = new LinkedList<Cidade>();
	}
	
	//GET / SET.
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(LinkedList<Cidade> cidades) {
		this.cidades = cidades;
	}
}