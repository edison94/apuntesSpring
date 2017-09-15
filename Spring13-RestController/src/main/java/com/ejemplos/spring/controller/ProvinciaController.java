package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Provincia;
import com.ejemplos.spring.model.ProvinciaList;
import com.ejemplos.spring.service.ProvinciaService;



/*
Spring 4.0 introduced @RestController, 
a specialized version of the controller which is a convenience annotation 
that does nothing more than add the @Controller and @ResponseBody annotations. 
By annotating the controller class with @RestController annotation, 
you no longer need to add @ResponseBody to all the request mapping methods.
*/ 
@RestController
public class ProvinciaController {
	
	@Autowired
	private ProvinciaService service;

	//Debo incluir lo del UTF-8 para las tildes
	//http://stackoverflow.com/questions/3616359/who-sets-response-content-type-in-spring-mvc-responsebody
	//Este sólo es valido para JSON, porque devuelve un LIST y en XML necesito una estructura más a medida
	@RequestMapping(
			value = "/provincia/listado1", 
			method = RequestMethod.GET, 
			headers ={"Accept=application/json"},			
			produces = "application/json; charset=utf-8")
	public List<Provincia> getProvincias() {
		return service.getProvincias();
	}
	
	//Valido para JSON y XML... aunque lo voy a usar solo para XML
	//Devuelvo una estructura más a medida
	//El  service  me la da
	@RequestMapping(value = "/provincia/listado2", 
			method = RequestMethod.GET,
			headers ={"Accept=application/xml"},
			produces={"application/xml"})
	public ProvinciaList getProvinciasXML()  {
		return service.getProvinciasXML();
	}		
	
	//A priori los dos métodos siguientes se podrian agrupar
	@RequestMapping(value = "/provincia/{id}", 
			method = RequestMethod.GET,
			headers ={"Accept=application/json"},
			produces={"application/json;charset=utf-8"})
	public Provincia getProvinciaByIdJson(@PathVariable int id) {
		return service.getProvinciaById(id);
	}	
	
	@RequestMapping(value = "/provincia/{id}", 
			method = RequestMethod.GET,
			headers ={"Accept=application/xml"},
			produces={"application/xml"})
	public Provincia getProvinciaByIdXML(@PathVariable int id) {
		return service.getProvinciaById(id);
	}		
	
}
