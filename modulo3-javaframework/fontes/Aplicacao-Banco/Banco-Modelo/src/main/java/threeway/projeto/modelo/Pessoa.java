package threeway.projeto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends EntidadeBanco {

	private static final long serialVersionUID = -8152860402961368470L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
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
