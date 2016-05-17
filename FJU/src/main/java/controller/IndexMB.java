package controller;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="indexMB")
public class IndexMB {
	
	private String includePage;

	public void botaoCadastrar() {
		setIncludePage("Cadastro.xhtml");
	}
	public void botaoUsuarios() {
		setIncludePage("Main.xhtml");
	}
	
	public String getIncludePage() {
		return includePage;
	}
	public void setIncludePage(String includePage) {
		this.includePage = includePage;
	}
}
