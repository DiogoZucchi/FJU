package model;

public class PessoaMidia extends Pessoa{
	private String cursos;
	private String equipamentos;
	private int departamento;

	public String getCursos() {
		return cursos;
	}
	public void setCursos(String cursos) {
		this.cursos = cursos;
	}
	public String getEquipamentos() {
		return equipamentos;
	}
	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}
	public int getDepartamento() {
		return departamento;
	}
	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}
}
