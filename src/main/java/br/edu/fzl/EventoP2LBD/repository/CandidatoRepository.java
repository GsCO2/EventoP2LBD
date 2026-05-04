package br.edu.fzl.EventoP2LBD.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.fzl.EventoP2LBD.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
	@Query("SELECT cd FROM Candidato cd JOIN cd.curso cs WHERE LOWER(cs.nome) = LOWER(:nome)")
	List<Candidato> findByCursoInteresse(@Param("nome") String nome);

	List<Candidato> findByBairro(String bairro);

	@Query("SELECT cd FROM Candidato cd JOIN cd.curso cs ORDER BY cs.nome ASC")
	List<Candidato> findAllByOrderByCursoInteresseAsc();

	List<Candidato> findAllByOrderByBairroAsc();

	@Query(value = "SELECT TOP 10 * FROM Candidato ORDER BY dataCad ASC", nativeQuery = true)
	List<Candidato> findTop10Primeiros();

	@Query(value = "SELECT TOP 10 * FROM Candidato ORDER BY dataCad DESC", nativeQuery = true)
	List<Candidato> findTop10Ultimos();
}
