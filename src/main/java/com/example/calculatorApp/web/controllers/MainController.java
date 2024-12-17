package com.example.calculatorApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String displayIndex(@RequestParam(name="name", required=false,
			defaultValue="World") String name, Model model) {
		return "index"; // maps to webapp/WEB-INF/templates/index.html
	}
}