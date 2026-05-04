package br.edu.fzl.EventoP2LBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.fzl.EventoP2LBD.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
	
}
