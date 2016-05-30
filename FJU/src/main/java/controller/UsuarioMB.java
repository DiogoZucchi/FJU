package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import model.Usuario;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioMB {

	private Usuario usuario = new Usuario();
	private boolean isLogado;

	public String doLogin() {
		UsuarioDao usuarioDao = new UsuarioDao();
		usuario = usuarioDao.listarUm(usuario);
		if (usuario == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			// try {
			System.out.println("Entro");
			isLogado = true;
			return "/Index.xhtml?faces-redirect=true";
			// FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
			/*
			 * } catch (IOException e) { e.printStackTrace(); } return null;
			 */
		}
	}
	
	public String doLogout() {
		usuario = null;
		isLogado = false;
		return "/Login.xhtml?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}
}
