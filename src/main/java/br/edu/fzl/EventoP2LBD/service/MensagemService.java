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
		int novoId;
		if(mRepo.buscarUltimoId() == null) {
			novoId = 1;
		} else {
			novoId = mRepo.buscarUltimoId() + 1;
		}
		m.setId(novoId);
		mRepo.save(m);
		return "Mensagem salva";
	}

	public String alterar(Mensagem m) throws Exception {
		if (!mRepo.existsById(m.getId())) {
			throw new Exception("Mensagem não existe");
		}
		mRepo.save(m);
		return "Mensagem alterada";
	}

	public String excluir(Mensagem m) throws Exception {

		if (!mRepo.existsById(m.getId())) {
			throw new Exception("Mensagem não encontrada para exclusão");
		}

		mRepo.deleteById(m.getId());
		return "Mensagem excluída";
	}

	public Mensagem buscar(Mensagem m) throws Exception {
		return mRepo.findById(m.getId()).orElseThrow(() -> new Exception("Mensagem não encontrada"));
	}

	public List<Mensagem> listar() {
		return mRepo.findAll();
	}
}
