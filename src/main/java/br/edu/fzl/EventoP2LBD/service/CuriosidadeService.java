package br.edu.fzl.EventoP2LBD.service;

import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.model.Curiosidade;
import br.edu.fzl.EventoP2LBD.model.Videogame;
import br.edu.fzl.EventoP2LBD.repository.CuriosidadeRepository;

@Service
public class CuriosidadeService {
	
	private CuriosidadeRepository cRepo;
	
	public void inserir(Curiosidade c) {
		cRepo.save(c);
	}
	
	public long countByVideogame(Videogame v) {
		return cRepo.countByVideogame(v);
	}
}
