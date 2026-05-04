package br.edu.fzl.EventoP2LBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.edu.fzl.EventoP2LBD.service.CandidatoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/consultaCandidatos")
public class AdminCandidatoController {

	@Autowired
	private CandidatoService service;

	@GetMapping
	public String listar(@RequestParam(required = false) String acao, 
			@RequestParam(required = false) String valor,
			HttpSession session, Model model) {
		if (!isAdmin(session)) {
			return "redirect:/login";
		}

		try {
			if ("curso".equalsIgnoreCase(acao)) {
				model.addAttribute("lista", service.listarPorCurso(valor));

			} else if ("bairro".equalsIgnoreCase(acao)) {
				model.addAttribute("lista", service.listarPorBairro(valor));

			} else if ("ordenarCurso".equalsIgnoreCase(acao)) {
				model.addAttribute("lista", service.ordenadoPorCurso());

			} else if ("ordenarBairro".equalsIgnoreCase(acao)) {
				model.addAttribute("lista", service.ordenadoPorBairro());

			} else if ("primeiros".equalsIgnoreCase(acao)) {
				model.addAttribute("lista", service.primeirosDez());

			} else if ("ultimos".equalsIgnoreCase(acao)) {
				model.addAttribute("lista", service.ultimosDez());

			} else {
				model.addAttribute("lista", service.listar());
			}

		} catch (Exception e) {
			model.addAttribute("erro", e.getMessage());
			model.addAttribute("lista", service.listar());
		}

		return "consultaCandidatos";
	}

	private boolean isAdmin(HttpSession session) {
		Boolean logado = (Boolean) session.getAttribute("adminLogado");
		return logado != null && logado;
	}
}