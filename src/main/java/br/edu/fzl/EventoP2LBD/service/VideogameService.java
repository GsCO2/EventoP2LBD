package br.edu.fzl.EventoP2LBD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.model.Videogame;
import br.edu.fzl.EventoP2LBD.repository.VideogameRepository;
//SRP - Cada entidade tem seu Service

@Service
public class VideogameService {
	
	@Autowired
	private VideogameRepository vRepository;
	
	public void inserir(Videogame videogame) {
        vRepository.save(videogame);
    }
	
	public List<Videogame> listarTodos() {
        return vRepository.findAll();
    }
	
	public long count() {
		return vRepository.count();
	}
	
	public Videogame buscar(int id) {
		return vRepository.findById(id).orElseThrow();
	}
}
