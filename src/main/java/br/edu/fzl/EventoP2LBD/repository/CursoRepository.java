package br.edu.fzl.EventoP2LBD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.fzl.EventoP2LBD.model.Curso;
//SRP -> cada classe tem seu repo
//ISP -> APENAS METODOS QUE VAI UTILIZAR
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
