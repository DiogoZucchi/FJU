package controller;

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
			//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(usuario.getLogin(), usuario);
			isLogado = true;
			return "/restricted/index.xhtml?faces-redirect=true";
		}
	}
	
	public String doLogout() {
		usuario = null;
		isLogado = false;
		return "/login.xhtml?faces-redirect=true";
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
