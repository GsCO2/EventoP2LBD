package br.edu.fzl.EventoP2LBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.fzl.EventoP2LBD.service.MensagemService;

@Controller
public class MensagemController {
	
	@Autowired
	private MensagemService mService;
}
