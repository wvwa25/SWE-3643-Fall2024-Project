package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class MainController {

	@GetMapping("/")
	public String displayMainPage(Model model) {
		model.addAttribute("message", "Hello, welcome to the JSP web application!");
		return "view"; // Maps to view.jsp in /WEB-INF/views/
	}
}