package br.edu.fzl.EventoP2LBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.fzl.EventoP2LBD.model.Mensagem;
//SRP -> cada classe tem seu repo
//ISP -> APENAS METODOS QUE VAI UTILIZAR
public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
	@Query("SELECT MAX(m.id) FROM Mensagem m")
    Integer buscarUltimoId();
}
