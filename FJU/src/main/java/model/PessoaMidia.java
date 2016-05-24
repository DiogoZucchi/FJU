package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="pessoaMidia")
@DiscriminatorValue(value="MID")
public class PessoaMidia extends Pessoa{
	
	@ManyToMany
    @JoinTable(name="midia_tem_cursos", joinColumns= @JoinColumn(name="pessoa_id"), inverseJoinColumns= @JoinColumn(name="curso_id"))
	private List<Curso> cursos;
	
	@ManyToMany
	@JoinTable(name="midia_tem_equipamentos", joinColumns= @JoinColumn(name="pessoa_id"), inverseJoinColumns= @JoinColumn(name="equipamento_id"))
	private List<Equipamento> equipamentos;
	
	@Column(name="departamento")
	private int departamento;
	
	//GET - SET.
	public int getDepartamento() {
		return departamento;
	}
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
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
}
