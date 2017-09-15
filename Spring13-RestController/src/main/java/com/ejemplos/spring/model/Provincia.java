package com.ejemplos.spring.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

//We know that for working with JAXB marshalling for a class, we need to annotate it with @XmlRootElement annotation
@XmlRootElement
public class Provincia implements Serializable{
	
	private int codigoPostal;
	private String provincia;
	private String comunidadAutonoma;
	private int habitantes;
	private int superficie;
	public Provincia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provincia(int codigoPostal, String provincia,
			String comunidadAutonoma, int habitantes, int superficie) {
		super();
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.comunidadAutonoma = comunidadAutonoma;
		this.habitantes = habitantes;
		this.superficie = superficie;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}
	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
	public int getHabitantes() {
		return habitantes;
	}
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	@Override
	public String toString() {
		return "Provincia [\ncodigoPostal=" + codigoPostal + "\n, Provincia="
				+ provincia + ", \nComunidad Autonoma: " + comunidadAutonoma
				+ ", Num habitantes:" + habitantes + ", Superficie: " + superficie + "m2"
				+ "]";
	}




}
