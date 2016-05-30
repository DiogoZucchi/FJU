package controller;


import javax.faces.bean.ManagedBean;

import dao.BlocoDao;
import dao.CidadeDao;
import dao.EstadoDao;
import dao.FormacaoDao;
import dao.IdiomaDao;
import dao.PessoaMidiaDao;
import model.Estado;
import model.Formacao;
import model.Idioma;
import model.PessoaMidia;
import teste.CepWebService;

@ManagedBean(name="pessoaMidiaMB")
public class PessoaMidiaMB {
	private PessoaMidia pessoaMidia = new PessoaMidia();
	private PessoaMidiaDao pessoaMidiaDao;
	
	private String cep;
	private int blocoSelecionado;
	private int formacaoSelecionada;
	private int situacaoEscolaSelecionada;
	private int situacaoSuperiorSelecionada;
	private int idiomaSelecionado;
	private int nivelIdioma;
	private int departMidiaSelecionada;
	private int cursoSelecionado;
	private String estadoSelecionado;
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
		pessoaMidia.setBloco(blocoDao.listarUm(blocoSelecionado));
		//**************
		//INSERT CIDADE.
		CidadeDao cidadeDao = new CidadeDao();
		pessoaMidia.setCidade(cidadeDao.listarUm(cidadeSelecionada, estado));
		//**************
		//DEPARTAMENTO
		pessoaMidia.setDepartamento(departMidiaSelecionada);
		//**************
		//FORMA«√O
		Formacao formacao = new Formacao();
		FormacaoDao formacaoDao = new FormacaoDao();
		formacao.setGrauEscolaridade(formacaoSelecionada);
		formacao.setEscolaSituacao(situacaoEscolaSelecionada);
		formacao.setSuperiorSituacao(situacaoSuperiorSelecionada);
		formacao.setCurso(cursoSelecionado);
		formacaoDao.inserir(formacao);
		pessoaMidia.setFormacao(formacao);
		//**************
		//IDIOMA
		Idioma idioma = new Idioma();
		IdiomaDao idiomaDao = new IdiomaDao();
		idioma.setDescricao(idiomaSelecionado);
		idioma.setNivel(nivelIdioma);
		idiomaDao.inserir(idioma);
//		pessoaMidia.setIdiomas(idiomas);
		//**************		
		//INSERT PESSOA MIDIA.
		pessoaMidiaDao = new PessoaMidiaDao();
		pessoaMidiaDao.inserir(this.pessoaMidia);
		//********************
		
		
		return "Main";
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
	public int getFormacaoSelecionada() {
		return formacaoSelecionada;
	}
	public void setFormacaoSelecionada(int formacaoSelecionada) {
		this.formacaoSelecionada = formacaoSelecionada;
	}
	public int getSituacaoEscolaSelecionada() {
		return situacaoEscolaSelecionada;
	}
	public void setSituacaoEscolaSelecionada(int situacaoEscolaSelecionada) {
		this.situacaoEscolaSelecionada = situacaoEscolaSelecionada;
	}
	public int getSituacaoSuperiorSelecionada() {
		return situacaoSuperiorSelecionada;
	}
	public void setSituacaoSuperiorSelecionada(int situacaoSuperiorSelecionada) {
		this.situacaoSuperiorSelecionada = situacaoSuperiorSelecionada;
	}
	public int getIdiomaSelecionado() {
		return idiomaSelecionado;
	}
	public void setIdiomaSelecionado(int idiomaSelecionado) {
		this.idiomaSelecionado = idiomaSelecionado;
	}
	public int getNivelIdioma() {
		return nivelIdioma;
	}
	public void setNivelIdioma(int nivelIdioma) {
		this.nivelIdioma = nivelIdioma;
	}
	public int getDepartMidiaSelecionada() {
		return departMidiaSelecionada;
	}
	public void setDepartMidiaSelecionada(int departMidiaSelecionada) {
		this.departMidiaSelecionada = departMidiaSelecionada;
	}
	public int getCursoSelecionado() {
		return cursoSelecionado;
	}
	public void setCursoSelecionado(int cursoSelecionado) {
		this.cursoSelecionado = cursoSelecionado;
	}
}