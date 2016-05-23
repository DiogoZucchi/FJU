package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="templateMB")
public class TemplateMB {
	
	private String opcaoTemplate;
	
	public void opCadastro(){
		setOpcaoTemplate("Layout.xhtml");
	}
	public void opListar(){
		setOpcaoTemplate("Main.xhtml");
	}
	public void opBloco(){
		setOpcaoTemplate("Bloco.xhtml");
	}
	
	public String getOpcaoTemplate() {
		return opcaoTemplate;
	}
	public void setOpcaoTemplate(String opcaoTemplate) {
		this.opcaoTemplate = opcaoTemplate;
	}
}
