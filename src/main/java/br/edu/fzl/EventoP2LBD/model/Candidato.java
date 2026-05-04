package br.edu.fzl.EventoP2LBD.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "candidato")
public class Candidato {

	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Column(name = "email", length = 75, nullable = false, unique = true)
	private String email;
	@Column(name = "celular", length = 11, nullable = false, unique = true)
	private String telefone;
	@Column(name = "bairro", length = 50, nullable = false)
	private String bairro;
	@Column(name = "dataCad", nullable = false)
	private LocalDateTime dataCad;
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	private boolean aceitacao;
}
