package threeway.projeto.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Agencia extends EntidadeBanco {

	private Long identificador;

	private String nome;

	private Banco banco;

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
