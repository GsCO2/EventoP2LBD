package br.edu.fzl.EventoP2LBD.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.fzl.EventoP2LBD.service.CuriosidadeService;
import br.edu.fzl.EventoP2LBD.service.PopularBDService;
import br.edu.fzl.EventoP2LBD.service.VideogameService;
//SRP CADA TELA TEM SEU CONTROLLER
@Controller
public class CuriosidadeController {

	@Autowired
	private VideogameService vService;

	@Autowired
	private PopularBDService popularBDService;

	@Autowired
	private CuriosidadeService curiosidadeService;

	@GetMapping("/escolha")
	public String escolhas(Model model) {
		try {
			popularBDService.verificaPopula();
		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("videogames", vService.listarTodos());
		return "escolha";
	}

	@GetMapping("/curiosidade/{marcaId}")
	public String curiosidade(@PathVariable Integer marcaId, Model model) {
		model.addAttribute("marca", vService.buscar(marcaId).getNome());
	    model.addAttribute("mensagem", curiosidadeService.sortear(marcaId));
		return "curiosidade";
	}
}
