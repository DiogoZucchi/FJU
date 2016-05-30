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
		idiomaMap.put(1, "Alem�o");
		idiomaMap.put(2, "�rabe");
		idiomaMap.put(3, "Bengali");
		idiomaMap.put(4, "Chin�s");
		idiomaMap.put(5, "Coreano");
		idiomaMap.put(6, "Espanhol");
		idiomaMap.put(7, "Franc�s");
		idiomaMap.put(8, "Hindi");
		idiomaMap.put(9, "Ingl�s");
		idiomaMap.put(10, "Japon�s");
		idiomaMap.put(11, "Javan�s");
		idiomaMap.put(12, "Lahnda");
		idiomaMap.put(13, "Marati");
		idiomaMap.put(14, "Portugu�s");
		idiomaMap.put(15, "Russo");
		idiomaMap.put(16, "T�mil");
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
