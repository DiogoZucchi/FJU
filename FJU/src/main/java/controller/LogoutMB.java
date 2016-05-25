package controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="logoutMB")
public class LogoutMB {
		
	public String deslogar() {
		UsuarioMB.usuario = null;
		return "Login";
	}
}
