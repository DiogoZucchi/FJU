package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class PessoaMidia extends Pessoa{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToMany
	@JoinTable(name="midia_tem_cursos", joinColumns= @JoinColumn(name="pessoa_codigo"), inverseJoinColumns= @JoinColumn(name="curso_codigo"))
	private List<Curso> cursos;
	
	@ManyToMany
	@JoinTable(name="midia_tem_equipamentos", joinColumns= @JoinColumn(name="pessoa_codigo"), inverseJoinColumns= @JoinColumn(name="equipamento_codigo"))
	private List<Equipamento> equipamentos;
	
	private int departamento;

	//GET - SET.
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}
	public void setEquipamentos(List<Equipamento> equipamentos) {
		this.equipamentos = equipamentos;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
}
