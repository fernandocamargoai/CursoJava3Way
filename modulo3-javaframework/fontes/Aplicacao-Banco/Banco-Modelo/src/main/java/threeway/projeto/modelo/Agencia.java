package threeway.projeto.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Agencia extends EntidadeBanco {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 4090546250667070313L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_agencia")
	private Long identificador;

	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_banco")
	private Banco banco;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "agencia", cascade = CascadeType.ALL)
	private Collection<Conta> contas;

	public Agencia() {
	}

	public Agencia( String nome ) {

		this.nome = nome;

		contas = new ArrayList<Conta>();
	}

	public Agencia( String nome, Banco banco ) {

		this(nome);
		this.banco = banco;
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

	public Banco getBanco() {

		return banco;
	}

	public void setBanco(Banco banco) {

		this.banco = banco;
	}

	public Collection<Conta> getContas() {

		return contas;
	}

	public void setContas(Collection<Conta> contas) {

		this.contas = contas;
	}

}
