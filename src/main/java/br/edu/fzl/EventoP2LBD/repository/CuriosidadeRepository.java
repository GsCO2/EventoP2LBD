package br.edu.fzl.EventoP2LBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import br.edu.fzl.EventoP2LBD.model.Curiosidade;
import br.edu.fzl.EventoP2LBD.model.Videogame;

public interface CuriosidadeRepository extends JpaRepository<Curiosidade, Integer>{
	@Query(value = "CALL sp_ObterCuriosidadeAleatoria :videogameId", nativeQuery = true)
    String buscarCuriosidadeAleatoria(int videogameId);
	
	long countByVideogame(Videogame videogame);
	
	@Procedure(procedureName = "sp_ObterCuriosidadeAleatoria")
    String sortearCuriosidade(@Param("marca_id") Integer marcaId);
}
