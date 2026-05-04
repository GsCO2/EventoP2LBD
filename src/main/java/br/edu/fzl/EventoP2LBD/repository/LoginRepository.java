package br.edu.fzl.EventoP2LBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.fzl.EventoP2LBD.model.Candidato;
//SRP -> cada classe tem seu repo
//ISP -> APENAS METODOS QUE VAI UTILIZAR
@Repository
public interface LoginRepository extends JpaRepository<Candidato, Long> {
	@Query(value = "EXEC sp_validarLogin :login, :senha", nativeQuery = true)
	Integer validarLogin(@Param("login") String login, @Param("senha") String senha);
}
