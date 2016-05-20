package model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="bloco")
public class Bloco {
	private int codigo;
	private String nome;
	private Estado estado;
	private ArrayList<Cidade> cidades = new ArrayList<Cidade>();
	
	public Bloco() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@ManyToOne
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@OneToMany(cascade=CascadeType.ALL, mappedBy="bloco")
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(ArrayList<Cidade> cidades) {
		this.cidades = cidades;
	}
}