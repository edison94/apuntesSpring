package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Student;

@Controller
// si preguntas con /.. me encargo yo
@RequestMapping("/")
public class HelloWorldController {

	/*
	 * GET handler.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		System.out.println("--- enviando un model vacio ");
		Student student = new Student();
		model.addAttribute("student", student);
		return "registro";
	}

	/*
	 * When Spring sees "@Valid", it tries to find the validator for the object
	 * being validated. Spring automatically picks up validation annotations if
	 * you have "annotation-driven" enabled. Spring then invokes the validator
	 * and puts any errors in the BindingResult and adds the BindingResult to
	 * the view model
	 */

	// Fijate en los tres elementos de la cabecera
	@RequestMapping(method = RequestMethod.POST)
	public String saveRegistration(@Valid Student student, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("--- Hay algunos errores");
			return "registro";
		}

		model.addAttribute("success",
				"Estimado " + student.getFirstName() + " , su registro se ha completado de forma correcta");
		return "resumen";
	}

	/*
	 * Method used to populate the Section list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("sections")
	public List<String> initializeSections() {

		List<String> sections = new ArrayList<String>();
		sections.add("Graduado");
		sections.add("Licenciado");
		sections.add("Ingeniero");
		sections.add("Doctorado");
		return sections;
	}

	/*
	 * Method used to populate the country list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		countries.add("ESPAÑA");
		countries.add("USA");
		countries.add("CANADA");
		countries.add("FRANCIA");
		countries.add("ALEMANIA");
		countries.add("ITALIA");
		countries.add("ARGENTINA");
		countries.add("Otros sitios");
		return countries;
	}

	/*
	 * Method used to populate the subjects list in view. Note that here you can
	 * call external systems to provide real data.
	 */
	@ModelAttribute("subjects")
	public List<String> initializeSubjects() {
		System.out.print("------------------entrando en subjects");

		List<String> subjects = new ArrayList<String>();
		subjects.add("Fisicas");
		subjects.add("Quimica");
		subjects.add("Matematicas");
		subjects.add("Politicas");
		subjects.add("Viva la vida");
		subjects.add("Informatica");
		return subjects;
	}

}