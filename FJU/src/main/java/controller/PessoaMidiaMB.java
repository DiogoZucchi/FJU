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
	private String sexoSelecionado;
	private Cidade cidade = new Cidade();
	private Bloco bloco = new Bloco();
	
	
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
                cidade.setNome(nomeCidade);
                
                //ENDERE�O.
                pessoaMidia.setEndereco(endereco);
                
                //BAIRRO.
                pessoaMidia.setBairro(nomeBairro);
                
            }
            else {
                System.out.println("Servidor não está respondendo.");
            }            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }  
    }    	
	
	//CADASTRAR.
	public String cadastrarPessoa() {
		
		//INSERT BLOCO.
		EstadoDao estadoDao = new EstadoDao();
		BlocoDao blocoDao = new BlocoDao();
		Estado estado = new Estado();
		estado = estadoDao.listarUm(estadoSelecionado);
		bloco.setEstado(estado);
		blocoDao.inserir(bloco);
		pessoaMidia.setBloco(bloco);
		//*************
		
		//INSERT ESTADO.
		pessoaMidia.setEstado(estado);
		//**************
		
		//INSERT CIDADE.
		CidadeDao cidadeDao = new CidadeDao();
		setCidade(cidadeDao.listarUm(getCidade().getNome(), estadoSelecionado));
		getCidade().setBloco(bloco);
		cidadeDao.inserir(getCidade());
		pessoaMidia.setCidade(getCidade());
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
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public String getEstadoSelecionado() {
		return estadoSelecionado;
	}
	public void setEstadoSelecionado(String estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
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
	public Bloco getBloco() {
		return bloco;
	}
	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
}