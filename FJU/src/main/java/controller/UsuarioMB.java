package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import model.Usuario;

@ManagedBean(name="usuarioMB")
public class UsuarioMB {
	
	private UsuarioDao usuarioDao = new UsuarioDao();
	private Usuario usuario = new Usuario();
	
	 public String enviar() {
		  System.out.println("awd");
         usuario = usuarioDao.listarUm(usuario);
         if (usuario == null) {
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                      "Erro no Login!"));
               return null;
         } else {
        	 try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("Main.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
               return "main";
         }
	 }
	 
	 public String enviar2() {
         System.out.println("awd");
         return "main";
	 }

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
