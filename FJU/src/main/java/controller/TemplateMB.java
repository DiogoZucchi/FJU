package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="templateMB")
public class TemplateMB {
	
	private String opcaoTemplate;
	
	public void opCadastro(){
		setOpcaoTemplate("/restricted/cadastro.xhtml");
	}
	public void opListar(){
		setOpcaoTemplate("/restricted/listar.xhtml");
	}
	public void opBloco(){
		setOpcaoTemplate("/restricted/bloco.xhtml");
	}
	
	public String getOpcaoTemplate() {
		return opcaoTemplate;
	}
	public void setOpcaoTemplate(String opcaoTemplate) {
		this.opcaoTemplate = opcaoTemplate;
	}
}
