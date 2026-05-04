package br.edu.fzl.EventoP2LBD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "mensagem")
public class Mensagem {

	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "conteudo", length = 256, nullable = false)
	private String conteudo;
	@Column(name = "tipo", length = 30, nullable = false)
	private String tipo;
}
