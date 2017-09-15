package com.springmvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	/*
	 * public ModelAndView showMessage(
	 * 
	 * @RequestParam(value = "name", required = false, defaultValue = "World")
	 * String name) { public ModelAndView hello(@PathVariable("name") String
	 * name) }
	 */
	public ModelAndView sayHello() {
		ModelAndView model = new ModelAndView("welcome");
		// model.setViewName("welcome");
		model.addObject("greeting", "Cuanto tiempo sin veros a todos");
		// Sí.. ya sé que está obsoleto
		model.addObject("fecha", new Date());

		return model;
	}

}
