package br.com.threeway.locadora.domain;

import javax.persistence.*;

@Entity
public class Filme {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private TipoFilme tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoFilme getTipo() {
		return tipo;
	}

	public void setTipo(TipoFilme tipo) {
		this.tipo = tipo;
	}
}
