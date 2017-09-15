package com.springmvc.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Cuanto tiempo sin veros a todos");
		//Sí.. ya sé que está obsoleto
		model.addAttribute("fecha", new Date());		
		
		return "welcome";
	}

}
