package br.com.threeway.locadora.domain;

public class Filme {

	private Long id;
	private String nome;
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

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Filme{");
		sb.append("id=").append(id);
		sb.append(", nome='").append(nome).append('\'');
		sb.append(", tipo=").append(tipo);
		sb.append('}');
		return sb.toString();
	}
}
