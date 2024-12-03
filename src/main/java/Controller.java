package main.java.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
