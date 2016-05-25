package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DadosEspirituais {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	private Date dtInicioUniversal;
	
	private Date dtInicioFJU;
	
	private Date dtEspiritoSanto;
	
	private Date dtBatismo;
	
	private boolean isObreiro;

	//GET - SET.
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDtInicioUniversal() {
		return dtInicioUniversal;
	}
	public void setDtInicioUniversal(Date dtInicioUniversal) {
		this.dtInicioUniversal = dtInicioUniversal;
	}
	public Date getDtInicioFJU() {
		return dtInicioFJU;
	}
	public void setDtInicioFJU(Date dtInicioFJU) {
		this.dtInicioFJU = dtInicioFJU;
	}
	public Date getDtEspiritoSanto() {
		return dtEspiritoSanto;
	}
	public void setDtEspiritoSanto(Date dtEspiritoSanto) {
		this.dtEspiritoSanto = dtEspiritoSanto;
	}
	public Date getDtBatismo() {
		return dtBatismo;
	}
	public void setDtBatismo(Date dtBatismo) {
		this.dtBatismo = dtBatismo;
	}
	public boolean isObreiro() {
		return isObreiro;
	}
	public void setObreiro(boolean isObreiro) {
		this.isObreiro = isObreiro;
	}
}
