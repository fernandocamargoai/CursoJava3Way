package threeway.projeto.modelo;

public class Pessoa extends EntidadeBanco {

	private Long identificador;

	private String nome;

	private String telefone;

	private String endereco;

	public Pessoa() {

	}

	public Pessoa( String nome ) {

		this.nome = nome;
	}

	@Override
	public Long getIdentificador() {

		return identificador;
	}

	public void setIdentificador(Long identificador) {

		this.identificador = identificador;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getTelefone() {

		return telefone;
	}

	public void setTelefone(String telefone) {

		this.telefone = telefone;
	}

	public String getEndereco() {

		return endereco;
	}

	public void setEndereco(String endereco) {

		this.endereco = endereco;
	}

	public void ImprimeNome() {

		System.out.println("O nome da pessoa é : " + nome);

	}

}
