package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "formacaoMB")
public class FormacaoMB {

	public Map<Integer, String> cursoMap;

	public FormacaoMB() {
		popularFormacaoMap();
	}

	public void popularFormacaoMap() {
		cursoMap = new LinkedHashMap<Integer, String>();
		cursoMap.put(1, "Administra��o");
		cursoMap.put(2, "Arquitetura e Urbanismo");
		cursoMap.put(3, "Biomedicina");
		cursoMap.put(4, "Ci�ncia da Computa��o");
		cursoMap.put(5, "Ci�ncias Atuariais");
		cursoMap.put(6, "Ci�ncias Biol�gicas");
		cursoMap.put(7, "Ci�ncias Cont�beis");
		cursoMap.put(8, "Ci�ncias Econ�micas");
		cursoMap.put(9, "Comunica��o Social (Jornalismo)");
		cursoMap.put(10, "Comunica��o Social (Publicidade e Propaganda)");
		cursoMap.put(11, "Desenho Industrial");
		cursoMap.put(12, "Direito");
		cursoMap.put(13, "Educa��o F�sica");
		cursoMap.put(14, "Enfermagem");
		cursoMap.put(15, "Engenharia Aeron�utica");
		cursoMap.put(16, "Engenharia Ambiental");
		cursoMap.put(17, "Engenharia Civil");
		cursoMap.put(18, "Engenharia de Computa��o");
		cursoMap.put(19, "Engenharia de Controle e Automa��o (Mecatr�nica)");
		cursoMap.put(20, "Engenharia de Petr�leo");
		cursoMap.put(21, "Engenharia de Produ��o Mec�nica");
		cursoMap.put(22, "Engenharia El�trica (Eletr�nica/Eletrot�cnica)");
		cursoMap.put(23, "Engenharia Mec�nica");
		cursoMap.put(24, "Farm�cia");
		cursoMap.put(25, "F�sica");
		cursoMap.put(26, "Fisioterapia");
		cursoMap.put(27, "Fonoaudiologia");
		cursoMap.put(28, "Geografia (Licenciatura)");
		cursoMap.put(29, "Hist�ria (Licenciatura)");
		cursoMap.put(30, "Hotelaria");
		cursoMap.put(31, "Letras");
		cursoMap.put(32, "Matem�tica");
		cursoMap.put(33, "Medicina");
		cursoMap.put(34, "Medicina Veterin�ria");
		cursoMap.put(35, "Moda");
		cursoMap.put(36, "Nutri��o");
		cursoMap.put(37, "Odontologia");
		cursoMap.put(38, "Pedagogia");
		cursoMap.put(39, "Propaganda e Marketing");
		cursoMap.put(40, "Psicologia");
		cursoMap.put(41, "Qu�mica");
		cursoMap.put(42, "Rela��es Internacionais");
		cursoMap.put(43, "Secretariado Executivo Bil�ngue");
		cursoMap.put(44, "Servi�o Social");
		cursoMap.put(45, "Sistemas de Informa��o");
		cursoMap.put(46, "Terapia Ocupacional");
		cursoMap.put(47, "Turismo");
		cursoMap.put(48, "Zootecnia");

	}

	public Map<Integer, String> getCursoMap() {
		return cursoMap;
	}
	public void setCursoMap(Map<Integer, String> cursoMap) {
		this.cursoMap = cursoMap;
	}
}
