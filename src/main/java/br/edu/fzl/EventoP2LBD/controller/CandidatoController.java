package br.edu.fzl.EventoP2LBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.fzl.EventoP2LBD.service.CandidatoService;
import br.edu.fzl.EventoP2LBD.service.CursoService;

@Controller
public class CandidatoController {
	@Autowired
	private CandidatoService candService;
	@Autowired
	private CursoService cursoService;

	@GetMapping("/cadastro")
	public String candidato(Model model) {
		model.addAttribute("cursos", cursoService.listar());
		return "cadastro";
	}

	@PostMapping("/cadastro")
	public String inserir(@RequestParam String nome, 
				@RequestParam String email, 
				@RequestParam String celular,
				@RequestParam String bairro,
				@RequestParam int idCurso,
				@RequestParam (required = false) Boolean aceitacao, Model model) {
		try {	
			boolean aceitou = aceitacao != null && aceitacao;
			candService.inserir(nome, email, celular, bairro, idCurso, aceitou);
	        return "redirect:/confirmacao";
	    } catch (Exception e) {
	        System.out.println("erro ao salvar candidato: " + e.getMessage());
	        model.addAttribute("erro", e.getMessage());
	        model.addAttribute("cursos", cursoService.listar());
	        return "cadastro";
	    }
	}
}
