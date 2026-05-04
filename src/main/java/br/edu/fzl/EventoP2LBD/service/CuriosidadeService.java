package br.edu.fzl.EventoP2LBD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.model.Curiosidade;
import br.edu.fzl.EventoP2LBD.model.Videogame;
import br.edu.fzl.EventoP2LBD.repository.CuriosidadeRepository;

@Service
public class CuriosidadeService {
	
	@Autowired
	private CuriosidadeRepository cRepo;
	
	public void inserir(Curiosidade c) {
		cRepo.save(c);
	}
	
	public long countByVideogame(Videogame v) {
		return cRepo.countByVideogame(v);
	}
	
	public String sortear(Integer id) {
		return cRepo.sortearCuriosidade(id);
	}
}
