package controller;

import javax.faces.bean.ManagedBean;

import model.Bloco;
import model.Estado;

@ManagedBean(name="blocoMB")
public class BlocoMB {
	private Bloco bloco = new Bloco();
	private Estado estado = new Estado();
	
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
}
