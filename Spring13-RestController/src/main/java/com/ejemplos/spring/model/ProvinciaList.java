package com.ejemplos.spring.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//Esta anotacion No es necesaria para JSON
//Pero es necesario para que funcione bien XML
//Ese es el nombre del nodo Padre, por defecto cogeria el de la clase
@XmlRootElement(name="Provincias")
public class ProvinciaList {
	
	private List<Provincia> listaProvincias;


	//Lo ponemos protected para mejorar el control de JAXB
	protected ProvinciaList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProvinciaList(List<Provincia> listaProvincias) {
		super();
		this.listaProvincias = listaProvincias;
	}

	@XmlElement(name="provincia")  
	public List<Provincia> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}
	
	

}
