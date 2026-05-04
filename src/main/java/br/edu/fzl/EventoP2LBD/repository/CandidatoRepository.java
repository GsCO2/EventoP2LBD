package br.edu.fzl.EventoP2LBD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.fzl.EventoP2LBD.model.Curso;
import br.edu.fzl.EventoP2LBD.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
	@Query("SELECT cd FROM Candidato cd JOIN cd.curso cs WHERE cs = ?1")
    List<Candidato> findByCursoInteresse(Curso curso);
	
    List<Candidato> findByBairro(String bairro);
    
    @Query("SELECT cd FROM Candidato cd JOIN cd.curso cs ORDER BY cs.nome ASC")
    List<Candidato> findAllByOrderByCursoInteresseAsc();
    
    List<Candidato> findAllByOrderByBairroAsc();

    @Query(value = "SELECT TOP 10 * FROM Candidatos ORDER BY data_hora_cadastro ASC", nativeQuery = true)
    List<Candidato> findTop10Primeiros();

    @Query(value = "SELECT TOP 10 * FROM Candidatos ORDER BY data_hora_cadastro DESC", nativeQuery = true)
    List<Candidato> findTop10Ultimos();
}
