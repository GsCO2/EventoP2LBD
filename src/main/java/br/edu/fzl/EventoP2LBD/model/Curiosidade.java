package br.edu.fzl.EventoP2LBD.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "curiosidade")
public class Curiosidade {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "conteudo", length = 256, nullable = false)
	private String conteudo;
	@ManyToOne
    @JoinColumn(name = "videogame_id")
    private Videogame videogame;
	
}