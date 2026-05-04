package br.edu.fzl.EventoP2LBD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//SRP CADA TELA TEM SEU CONTROLLER
@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
