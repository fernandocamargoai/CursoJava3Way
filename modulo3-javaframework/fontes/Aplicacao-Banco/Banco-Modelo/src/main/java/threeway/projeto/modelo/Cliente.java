package threeway.projeto.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;

import threeway.projeto.modelo.enums.EnumStatus;

@Entity
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Cliente extends Pessoa implements Comparable<Cliente> {

	private static final long serialVersionUID = 1130736339966591348L;

	private String cpf;

	private String rg;
	
	@Enumerated(EnumType.STRING)
	private EnumStatus statusCliente;


	public Cliente() {

	}

	public Cliente( String nome, String cpf ) {

		super(nome);

		this.cpf = cpf;
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf(String cpf) {

		this.cpf = cpf;
	}

	public String getRg() {

		return rg;
	}

	public void setRg(String rg) {

		this.rg = rg;
	}
	
	@PrePersist
	private void salvarStatus() {
		
		statusCliente = EnumStatus.ATIVO;
	}

	/**
	 * Permite comparações, usando para classificar
	 */
	public int compareTo(Cliente o) {

		// comparando somente campo nome
		return getNome().compareTo(o.getNome());
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ( ( cpf == null ) ? 0 : cpf.hashCode() );
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public final void ImprimeNome() {

		System.out.println("Nome do cliente é : " + getNome() + " Nº CPF: " + cpf + " Seu endereco :" + getEndereco());

	}
	
	
	public EnumStatus getStatusCliente() {
		return statusCliente;
	}

	public void setStatusCliente(EnumStatus statusCliente) {
		this.statusCliente = statusCliente;
	}

}
