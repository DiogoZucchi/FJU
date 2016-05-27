package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private long codigo;
    
    private String nome;
	
	private Date dtNasc;
	
	private Character sexo;
	
	private String cep;

	private String endereco;
	
	private Integer numEnd;
	
	private String bairro;
	
	private String telefone;
	
	private String celular;
	
	private String email;
	
	private String instagram;
	
	private Date dataDoCadastro;

	@ManyToOne
	@JoinColumn(name="formacao_codigo")
	private Formacao formacao; 
	
	@ManyToOne
	@JoinColumn(name="estado_uf")
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name="cidade_codigo")
	private Cidade cidade;
	
	@ManyToOne
	@JoinColumn(name="bloco_codigo")
	private Bloco bloco;

	@ManyToOne
	@JoinColumn(name="dadosEspirituais_codigo")
	private DadosEspirituais dadosEspirituais;
	
	@ManyToMany
	@JoinTable(name="pessoa_tem_idioma", joinColumns= @JoinColumn(name="pessoa_codigo"), inverseJoinColumns= @JoinColumn(name="idioma_codigo"))
	private List<Idioma> idiomas;
	
	//GET - SET.
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumEnd() {
		return numEnd;
	}
	public void setNumEnd(Integer numEnd) {
		this.numEnd = numEnd;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	public Formacao getFormacao() {
		return formacao;
	}
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	public Date getDataDoCadastro() {
		return dataDoCadastro;
	}
	public void setDataDoCadastro(Date dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
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
	public Bloco getBloco() {
		return bloco;
	}
	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	public DadosEspirituais getDadosEspirituais() {
		return dadosEspirituais;
	}
	public void setDadosEspirituais(DadosEspirituais dadosEspirituais) {
		this.dadosEspirituais = dadosEspirituais;
	}
	public List<Idioma> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
}