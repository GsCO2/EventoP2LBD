package br.edu.fzl.EventoP2LBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.fzl.EventoP2LBD.service.LoginService;
import jakarta.servlet.http.HttpSession;
//SRP CADA TELA TEM SEU CONTROLLER
@Controller
public class LoginController {

	@Autowired
	private LoginService lService;

	@GetMapping("/login")
	public String telaLogin(HttpSession session) {
		Boolean logado = (Boolean) session.getAttribute("adminLogado");
		if (logado != null && logado) {
			return "redirect:/consultaCandidatos";
		}
		return "login";
	}

	@PostMapping("/login")
	public String autenticar(@RequestParam String login, @RequestParam String senha,
			HttpSession session, Model model) {
		try {
			if (lService.login(login, senha)) {
				session.setAttribute("adminLogado", true);
				return "redirect:/consultaCandidatos";
			} else {
				model.addAttribute("erro", "Login ou senha inválidos.");
				return "login";
			}
		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			return "login";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
