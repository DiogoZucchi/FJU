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
		cursoMap.put(1, "Administração");
		cursoMap.put(2, "Arquitetura e Urbanismo");
		cursoMap.put(3, "Biomedicina");
		cursoMap.put(4, "Ciência da Computação");
		cursoMap.put(5, "Ciências Atuariais");
		cursoMap.put(6, "Ciências Biológicas");
		cursoMap.put(7, "Ciências Contábeis");
		cursoMap.put(8, "Ciências Econômicas");
		cursoMap.put(9, "Comunicação Social (Jornalismo)");
		cursoMap.put(10, "Comunicação Social (Publicidade e Propaganda)");
		cursoMap.put(11, "Desenho Industrial");
		cursoMap.put(12, "Direito");
		cursoMap.put(13, "Educação Física");
		cursoMap.put(14, "Enfermagem");
		cursoMap.put(15, "Engenharia Aeronáutica");
		cursoMap.put(16, "Engenharia Ambiental");
		cursoMap.put(17, "Engenharia Civil");
		cursoMap.put(18, "Engenharia de Computação");
		cursoMap.put(19, "Engenharia de Controle e Automação (Mecatrônica)");
		cursoMap.put(20, "Engenharia de Petróleo");
		cursoMap.put(21, "Engenharia de Produção Mecânica");
		cursoMap.put(22, "Engenharia Elétrica (Eletrônica/Eletrotécnica)");
		cursoMap.put(23, "Engenharia Mecânica");
		cursoMap.put(24, "Farmácia");
		cursoMap.put(25, "Física");
		cursoMap.put(26, "Fisioterapia");
		cursoMap.put(27, "Fonoaudiologia");
		cursoMap.put(28, "Geografia (Licenciatura)");
		cursoMap.put(29, "História (Licenciatura)");
		cursoMap.put(30, "Hotelaria");
		cursoMap.put(31, "Letras");
		cursoMap.put(32, "Matemática");
		cursoMap.put(33, "Medicina");
		cursoMap.put(34, "Medicina Veterinária");
		cursoMap.put(35, "Moda");
		cursoMap.put(36, "Nutrição");
		cursoMap.put(37, "Odontologia");
		cursoMap.put(38, "Pedagogia");
		cursoMap.put(39, "Propaganda e Marketing");
		cursoMap.put(40, "Psicologia");
		cursoMap.put(41, "Química");
		cursoMap.put(42, "Relações Internacionais");
		cursoMap.put(43, "Secretariado Executivo Bilíngue");
		cursoMap.put(44, "Serviço Social");
		cursoMap.put(45, "Sistemas de Informação");
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
