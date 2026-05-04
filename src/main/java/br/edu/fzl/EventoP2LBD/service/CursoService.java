package br.edu.fzl.EventoP2LBD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.model.Curso;
import br.edu.fzl.EventoP2LBD.repository.CursoRepository;
//SRP - Cada entidade tem seu Service

@Service
public class CursoService {
	@Autowired
	private CursoRepository cRepo;
	
	public String inserir(Curso c) {
		cRepo.save(c);
		return "Curso salvo";
	}
	
	public String alterar(Curso c) {
		cRepo.save(c);
		return "Curso alterado";
	}
	
	public Curso buscar(Curso c) throws Exception {
		return cRepo.findById(c.getId()).orElseThrow(() -> new Exception("Curso não encontrada"));
	}
	
	public List<Curso> listar() {
		return cRepo.findAll();
	}
	
	public String deletar(Curso c) {
		cRepo.delete(c);
		return "Curso excluído";
	}
	
}
