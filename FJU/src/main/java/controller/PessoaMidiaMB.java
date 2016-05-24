package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import dao.BlocoDao;
import dao.CidadeDao;
import dao.EstadoDao;
import dao.PessoaMidiaDao;
import model.Bloco;
import model.Cidade;
import model.Estado;
import model.PessoaMidia;
import teste.CepWebService;

@ManagedBean(name="pessoaMidiaMB")
public class PessoaMidiaMB {
	private PessoaMidia pessoaMidia = new PessoaMidia();
	private PessoaMidiaDao pessoaMidiaDao;
	
	private String cep;
	private String estadoSelecionado;
	private int blocoSelecionado;
	private String cidadeSelecionada;
	private String sexoSelecionado;
	
	public void buscaLogradouro() {
		
        try {
            CepWebService cepWebService = new CepWebService(this.cep);
                
            if (cepWebService.getResultado()==1) {
                String endereco = cepWebService.getTipo_logradouro() + " " + cepWebService.getLogradouro();
                String siglaEstado = cepWebService.getEstado();
                String nomeCidade = cepWebService.getCidade();
                String nomeBairro = cepWebService.getBairro();
                //int resultado = cepWebService.getResultado();
                
                //ESTADO.
                setEstadoSelecionado(siglaEstado);
                
                //CIDADE.
                setCidadeSelecionada(nomeCidade);
                
                //ENDERE«O.
                pessoaMidia.setEndereco(endereco);
                
                //BAIRRO.
                pessoaMidia.setBairro(nomeBairro);
                
            }
            else {
                System.out.println("Servidor n√£o est√° respondendo.");
            }            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }  
    }    	
	
	//CADASTRAR.
	public String cadastrarPessoa() {
		
		System.out.println("Entro1");
		//****************
		//*** ENDERE«O ***
		//****************
		//CEP
		pessoaMidia.setCep(cep);
		//INSERT ESTADO.
		EstadoDao estadoDao = new EstadoDao();
		Estado estado = estadoDao.listarUm(estadoSelecionado);
		pessoaMidia.setEstado(estado);
		//*************
		//INSERT BLOCO.
		BlocoDao blocoDao = new BlocoDao();
		System.out.println(blocoSelecionado);
		pessoaMidia.setBloco(blocoDao.listarUm(blocoSelecionado));
		//**************
		//INSERT CIDADE.
		CidadeDao cidadeDao = new CidadeDao();
		pessoaMidia.setCidade(cidadeDao.listarUm(cidadeSelecionada, estado));
		//**************
		
		//INSERT PESSOA MIDIA.
		pessoaMidiaDao = new PessoaMidiaDao();
		pessoaMidiaDao.inserir(this.pessoaMidia);
		//********************
		  
		return "main";
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEstadoSelecionado() {
		BlocoMB.estadoSelected = estadoSelecionado;
		CidadeMB.estadoSelected = estadoSelecionado;
		return estadoSelecionado;
	}
	public void setEstadoSelecionado(String estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
		BlocoMB.estadoSelected = this.estadoSelecionado;
		CidadeMB.estadoSelected = this.estadoSelecionado;
	}
	public String getSexoSelecionado() {
		return sexoSelecionado;
	}
	public void setSexoSelecionado(String sexoSelecionado) {
		this.sexoSelecionado = sexoSelecionado;
	}
	public PessoaMidia getPessoaMidia() {
		return pessoaMidia;
	}
	public void setPessoaMidia(PessoaMidia pessoaMidia) {
		this.pessoaMidia = pessoaMidia;
	}
	public int getBlocoSelecionado() {
		return blocoSelecionado;
	}
	public void setBlocoSelecionado(int blocoSelecionado) {
		this.blocoSelecionado = blocoSelecionado;
	}
	public String getCidadeSelecionada() {
		return cidadeSelecionada;
	}
	public void setCidadeSelecionada(String cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}
}