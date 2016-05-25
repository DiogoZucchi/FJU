package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import model.Usuario;

@ManagedBean(name="usuarioMB")
@SessionScoped
public class UsuarioMB {
	
	static Usuario usuario = new Usuario();
	
	 public String enviar() {
		 UsuarioDao usuarioDao = new UsuarioDao();
         usuario = usuarioDao.listarUm(usuario);
         if (usuario == null) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                      "Erro no Login!"));
               return null;
         } else {
        	 try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("Index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
               return null;
         }
	 }
	 
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
