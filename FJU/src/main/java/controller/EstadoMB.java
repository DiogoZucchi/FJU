package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="estadoMB")
public class EstadoMB {
	public Map<String, String> estadoMap;
	static String estadoSelected;
	
	public EstadoMB() {
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
	
	public Map<String, String> getEstadoMap() {
		estadoSelected = estadoMap.get("AC");
		return estadoMap;
	}
	public void setEstadoMap(Map<String, String> estadoMap) {
		this.estadoMap = estadoMap;
	}

	public String getEstadoSelected() {
		return estadoSelected;
	}

	public void setEstadoSelected(String estadoSelected) {
		EstadoMB.estadoSelected = estadoSelected;
	}
	
}
