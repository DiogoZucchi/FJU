package controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="idiomaMB")
public class IdiomaMB {
	public Map<Integer, String> idiomaMap;
	
	public IdiomaMB() {
		popularEstadoMap();
	}

	public void popularEstadoMap() {
		idiomaMap = new LinkedHashMap<Integer, String>();
		idiomaMap.put(1, "Alemão");
		idiomaMap.put(2, "Árabe");
		idiomaMap.put(3, "Bengali");
		idiomaMap.put(4, "Chinês");
		idiomaMap.put(5, "Coreano");
		idiomaMap.put(6, "Espanhol");
		idiomaMap.put(7, "Francês");
		idiomaMap.put(8, "Hindi");
		idiomaMap.put(9, "Inglês");
		idiomaMap.put(10, "Japonês");
		idiomaMap.put(11, "Javanês");
		idiomaMap.put(12, "Lahnda");
		idiomaMap.put(13, "Marati");
		idiomaMap.put(14, "Português");
		idiomaMap.put(15, "Russo");
		idiomaMap.put(16, "Tâmil");
		idiomaMap.put(17, "Telugo");
		idiomaMap.put(18, "Turco");
		idiomaMap.put(19, "Urdu");
		idiomaMap.put(20, "Vietnamita");
	}

	public Map<Integer, String> getIdiomaMap() {
		return idiomaMap;
	}
	public void setIdiomaMap(Map<Integer, String> idiomaMap) {
		this.idiomaMap = idiomaMap;
	}
}
