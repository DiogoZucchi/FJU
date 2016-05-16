package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import dao.PessoaMidiaDao;
import model.Cidade;
import model.Estado;
import model.PessoaMidia;

@ManagedBean(name="pessoaMidiaMB")
public class PessoaMidiaMB {
	private PessoaMidia pessoaMidia = new PessoaMidia();
	private PessoaMidiaDao pessoaMidiaDao;
	
	private String cep;
	private String estadoSelecionado;
	private String sexoSelecionado;
	private Estado estado;
	private Cidade cidade;
	public Map<String, String> estadoMap;
	
	/*public void BuscaLogradouro() {
        try {
            CepWebService cepWebService = new CepWebService(this.cep);
                
            if (cepWebService.getResultado()==1) {
                String endereco = cepWebService.getTipo_logradouro() + " " + cepWebService.getLogradouro();
                String siglaEstado = cepWebService.getEstado();
                String nomeCidade = cepWebService.getCidade();
                String nomeBairro = cepWebService.getBairro();
                int resultado = cepWebService.getResultado();
                
                //ESTADO.
                estado = new Estado();
                estado.setUf(siglaEstado);
                
                //CIDADE.
                cidade = new Cidade();
                cidade.setNome(nomeCidade);
                
                //ENDERE�O.
                pessoaMidia = new PessoaMidia();
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
    }*/    	
	
	public PessoaMidiaMB() {
		popularEstadoMap();
	}
	
	public void popularEstadoMap() {
		estadoMap = new LinkedHashMap<String, String>();
		estadoMap.put("AC", "Acre");
		estadoMap.put("AL", "Alagoas");
		estadoMap.put("AP", "Amap�");
		estadoMap.put("AM", "Amazonas");
		estadoMap.put("BA", "Bahia");
		estadoMap.put("CE", "Cear�");
		estadoMap.put("DF", "Distrito Federal");
		estadoMap.put("ES", "Espirito Santo");
		estadoMap.put("GO", "Goi�s");
		estadoMap.put("MA", "Maranh�o");
		estadoMap.put("MT", "Mato Grosso");
		estadoMap.put("MS", "Mato Grosso do Sul");
		estadoMap.put("MG", "Minas Gerais");
		estadoMap.put("PA", "Par�");
		estadoMap.put("PB", "Paraiba");
		estadoMap.put("PR", "Paran�");
		estadoMap.put("PE", "Pernambuco");
		estadoMap.put("PI", "Piau�");
		estadoMap.put("RJ", "Rio de Janeiro");
		estadoMap.put("RN", "Rio Grande do Norte");
		estadoMap.put("RS", "Rio Grande do Sul");
		estadoMap.put("RO", "Rond�nia");
		estadoMap.put("RR", "Roraima");
		estadoMap.put("SC", "Santa Catarina");
		estadoMap.put("SP", "S�o Paulo");
		estadoMap.put("SE", "Sergipe");
		estadoMap.put("TO", "Tocantis");
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
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
	public Map<String, String> getEstadoMap() {
		return estadoMap;
	}
	public void setEstadoMap(Map<String, String> estadoMap) {
		this.estadoMap = estadoMap;
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
}