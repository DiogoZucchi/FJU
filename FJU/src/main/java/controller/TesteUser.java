package controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="testeUser")
public class TesteUser {
	
	private String nome;

	public String getNome() {
		System.out.println("Get");
		return nome;
	}
	public void setNome(String nome) {
		System.out.println("Set");
		this.nome = nome;
	}
	
	public void listar(){
		System.out.println("Listar");
	}
	
}
