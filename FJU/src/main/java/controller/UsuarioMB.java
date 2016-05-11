package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import model.Usuario;

@ManagedBean(name="usuarioMB")
@ViewScoped
public class UsuarioMB {
	
	private UsuarioDao usuarioDao = new UsuarioDao();
	private Usuario usuario = new Usuario();
	
	 public String enviar() {
		 System.out.println("ENVIAR");
         System.out.println("*** "+usuario.getId());
         /*usuario = usuarioDao.listarUm(usuario);
         if (usuario == null) {
               usuario = new Usuario();
               FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                                      "Erro no Login!"));
               return null;
         } else {
        	 System.out.println("Rr");
               */return "/main.xhtml";
         /*}*/
	 }

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
