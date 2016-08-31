package threeway.projeto.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import threeway.projeto.modelo.enums.EnumTipoConta;
import threeway.projeto.modelo.util.UtilData;

@Entity
public class Conta extends EntidadeBanco {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1922189501184969082L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private Long identificador;

	private Integer numero;

	private Double saldo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAbertura;
	
	@Transient
	private Collection<Transacao> transacoes;

	@ManyToOne
	@JoinColumn(name = "id_titular")
	private Cliente titular;

	@ManyToOne
	@JoinColumn(name = "id_agencia")
	private Agencia agencia;

	@Enumerated(EnumType.STRING)
	private EnumTipoConta tipoConta;

	// construtor padrão da classe Conta que define a data de criação da conta e inicializa o array de transacao
	public Conta() {

		dataAbertura = UtilData.data();
		transacoes = new ArrayList<Transacao>();
	}

	// construtor com tres parametros
	public Conta( Cliente cliente, Integer nconta, EnumTipoConta tipoConta ) {

		this();
		numero = nconta;
		titular = cliente;
		saldo = 0.0; // Conta em reais e zerada
		this.tipoConta = tipoConta;
	}

	@Override
	public Long getIdentificador() {

		return identificador;
	}

	public void setIdentificador(Long identificador) {

		this.identificador = identificador;
	}

	public Integer getNumero() {

		return numero;
	}

	public void setNumero(Integer numero) {

		this.numero = numero;
	}

	public Double getSaldo() {

		return saldo;
	}

	public void setSaldo(Double saldo) {

		this.saldo = saldo;
	}

	public Date getDataAbertura() {

		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {

		this.dataAbertura = dataAbertura;
	}


	public Collection<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(Collection<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Cliente getTitular() {

		return titular;
	}

	public void setTitular(Cliente titular) {

		this.titular = titular;
	}

	public Agencia getAgencia() {

		return agencia;
	}

	public void setAgencia(Agencia agencia) {

		this.agencia = agencia;
	}

	public EnumTipoConta getTipoConta() {

		return tipoConta;
	}

	public void setTipoConta(EnumTipoConta tipoConta) {

		this.tipoConta = tipoConta;
	}

	/**
	 * Testa a igualdade de um objeto com este
	 */
	@Override
	public boolean equals(Object objeto) {

		boolean resultado = false;
		if (( objeto != null ) && ( objeto instanceof Conta )) {
			Conta c = (Conta) objeto;
			if (getNumero() == c.getNumero()) {
				resultado = true;
			}
		}
		return resultado;
	}

	/**
	 * Gera código hash para tabelas de epalhamento
	 */
	@Override
	public int hashCode() {

		return getNumero();
	}

	@Override
	public String toString() {

		return getNumero() + "-" + getTitular().getNome();
	}
	
	public String getDataFormatada(){
		
		return UtilData.formataData(dataAbertura);
	}
}
