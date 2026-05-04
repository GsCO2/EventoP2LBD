package br.edu.fzl.EventoP2LBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository lRepo;
	
	public boolean login(String login, String senha) {
		Integer resultado = lRepo.validarLogin(login, senha);
		return resultado != null && resultado == 1;
	}
}
