package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", length=3, discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Pes")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="dtNasc")
	private Date dtNasc;
	
	@Column(name="sexo")
	private char sexo;
	
	@Column(name="cep")
	private String cep;
	
	@ManyToOne
	@JoinColumn(name="estado_uf")
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name="cidade_id")
	private Cidade cidade;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="numEnd")
	private int numEnd;
	
	@ManyToOne
	@JoinColumn(name="dadosEspirituais_id")
	private DadosEspirituais dadosEspirituais;
	
	@ManyToOne
	@JoinColumn(name="bloco_id")
	private Bloco bloco;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="celular")
	private String celular;
	
	@Column(name="email")
	private String email;
	
	@Column(name="instagram")
	private String instagram;
	
	@Column(name="grauInst")
	private String grauInstrucao;
	
	@Column(name="formacao")
	private String formacao;
	
	@ManyToMany
    @JoinTable(name="pessoa_tem_idioma", joinColumns= @JoinColumn(name="pessoa_id"), inverseJoinColumns= @JoinColumn(name="idioma_id"))
	private List<Idioma> idiomas;
	
	@Column(name="cep")
	private Date dataDoCadastro;
	
	//GET - SET.
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public DadosEspirituais getDadosEspirituais() {
		return dadosEspirituais;
	}
	public void setDadosEspirituais(DadosEspirituais dadosEspirituais) {
		this.dadosEspirituais = dadosEspirituais;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Bloco getBloco() {
		return bloco;
	}
	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNumEnd() {
		return numEnd;
	}
	public void setNumEnd(int numEnd) {
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
	public Date getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
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
	public String getGrauInstrucao() {
		return grauInstrucao;
	}
	public void setGrauInstrucao(String grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public Date getDataDoCadastro() {
		return dataDoCadastro;
	}
	public void setDataDoCadastro(Date dataDoCadastro) {
		this.dataDoCadastro = dataDoCadastro;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public List<Idioma> getIdiomas() {
		return idiomas;
	}
	public void setIdiomas(List<Idioma> idiomas) {
		this.idiomas = idiomas;
	}
}
