package br.edu.fzl.EventoP2LBD.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.fzl.EventoP2LBD.model.Candidato;
import br.edu.fzl.EventoP2LBD.model.Curso;
import br.edu.fzl.EventoP2LBD.repository.CandidatoRepository;
import br.edu.fzl.EventoP2LBD.repository.CursoRepository;

@Service
public class CandidatoService {
	@Autowired
	private CandidatoRepository cRepo;
	@Autowired
	private CursoRepository cursoRepo;

	public String inserir(String nome, String email, String celular, String bairro, Integer idCurso,
			Boolean aceitacao) throws Exception {
		try {
			Curso curso = cursoRepo.findById(idCurso).orElseThrow();
			Candidato c = new Candidato();
			c.setNome(nome);
			c.setEmail(email);
			c.setCelular(celular);
			c.setBairro(bairro);
			c.setDataCad(LocalDateTime.now());
			c.setCurso(curso);
			c.setAceitacao(aceitacao);
			cRepo.save(c);
			return "Salvo com sucesso";
		} catch (Exception e) {
			String msg = e.getMessage();
			if (msg.contains("Nome inválido")) {
				throw new Exception("Nome inválido.");
	        }

	        if (msg.contains("Email inválido")) {
	        	throw new Exception("E-mail inválido.");
	        }

	        if (msg.contains("Email já cadastrado")) {
	        	throw new Exception("Este e-mail já está cadastrado.");
	        }

	        if (msg.contains("Celular inválido")) {
	        	throw new Exception("Celular inválido. Use apenas números.");
	        }

	        if (msg.contains("Celular já cadastrado")) {
	        	throw new Exception("Este celular já está cadastrado.");
	        }
	        
	        throw new Exception("Bairro inválido.");
		}
	}

	public List<Candidato> listar() {
		return cRepo.findAll();
	}

	public List<Candidato> listarPorCurso(String nome) {
		return cRepo.findByCursoInteresse(nome);

	}

	public List<Candidato> listarPorBairro(String bairro) {
		return cRepo.findByBairro(bairro);
	}

	public List<Candidato> ordenadoPorCurso() {
		return cRepo.findAllByOrderByCursoInteresseAsc();
	}

	public List<Candidato> ordenadoPorBairro() {
		return cRepo.findAllByOrderByBairroAsc();
	}

	public List<Candidato> primeirosDez() {
		return cRepo.findTop10Primeiros();
	}

	public List<Candidato> ultimosDez() {
		return cRepo.findTop10Ultimos();
	}
}
