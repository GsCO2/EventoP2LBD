package br.edu.fzl.EventoP2LBD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.model.Mensagem;
import br.edu.fzl.EventoP2LBD.repository.MensagemRepository;

@Service
public class MensagemService {
	@Autowired
	private MensagemRepository mRepo;
	
	public String inserir(Mensagem m) {
		mRepo.save(m);
		return "Mensagem salva";
	}
	
	public String alterar(Mensagem m) {
		mRepo.save(m);
		return "Mensagem alterada";
	}
	
	public Mensagem buscar(Mensagem m) throws Exception {
		return mRepo.findById(m.getId()).orElseThrow(() -> new Exception("Mensagem não encontrada"));
	}
	
	public List<Mensagem> listar() {
		return mRepo.findAll();
	}
}
