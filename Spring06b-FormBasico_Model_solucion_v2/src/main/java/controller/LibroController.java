package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Libro;

@Controller
public class LibroController {

	@ModelAttribute("libro")
	public Libro getLibroObjectNew() {
		System.out.println("-- Genero Libro Nuevo");
		return new Libro();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public String initForm() {
		//Antes de entrar a la Pag01
		return "form1";
	}
	
	@RequestMapping(value = "/addLibro", method = RequestMethod.POST)		
	public String altaLibro() {
		return "form2";
	}	

}
