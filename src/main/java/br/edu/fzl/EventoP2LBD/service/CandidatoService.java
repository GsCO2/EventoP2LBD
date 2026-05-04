package br.edu.fzl.EventoP2LBD.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.model.Candidato;
import br.edu.fzl.EventoP2LBD.model.Curso;
import br.edu.fzl.EventoP2LBD.repository.CandidatoRepository;

@Service
public class CandidatoService {
	
	private CandidatoRepository cRepo;
	
	public String Inserir(Candidato c) {
		cRepo.save(c);
		return "Salvo com sucesso";
	}
	
	public List<Candidato> listar(){
		return cRepo.findAll();
	}
	public List<Candidato> listarPorCurso(Curso c) {
		return cRepo.findByCursoInteresse(c);

	}
	
	public List<Candidato> listarPorBairro(String bairro){
		return cRepo.findByBairro(bairro);
	}
	
	public List<Candidato> ordenadoPorCurso(){
		return cRepo.findAllByOrderByCursoInteresseAsc();
	}
	
	public List<Candidato> ordenadoPorBairro(){
		return cRepo.findAllByOrderByBairroAsc();
	}
	
	public List<Candidato> primeirosDez(){
		return cRepo.findTop10Primeiros();
	}
	
	public List<Candidato> ultimosDez(){
		return cRepo.findTop10Ultimos();
	}
}
