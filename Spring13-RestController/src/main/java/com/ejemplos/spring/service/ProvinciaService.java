package com.ejemplos.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ejemplos.spring.dao.Datos;
import com.ejemplos.spring.model.Provincia;
import com.ejemplos.spring.model.ProvinciaList;

@Service
public class ProvinciaService {
	
	@Autowired
	private Datos datos;
	
	public List<Provincia> getProvincias() {
		return datos.createProvinciaList();
	}
	
	public ProvinciaList getProvinciasXML() {
		return new ProvinciaList(datos.createProvinciaList());
	}
	
	public Provincia getProvinciaById(int id) {
		List<Provincia> listaProvincias = new ArrayList<Provincia>();
		listaProvincias = datos.createProvinciaList();

		for (Provincia provincia : listaProvincias) {
			if (provincia.getCodigoPostal() == id)
				return provincia;
		}

		return null;
	}		

}
