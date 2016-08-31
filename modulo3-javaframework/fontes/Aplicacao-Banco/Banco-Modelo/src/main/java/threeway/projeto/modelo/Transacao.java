package threeway.projeto.modelo;

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

import threeway.projeto.modelo.enums.EnumTipoTransacao;
import threeway.projeto.modelo.util.UtilData;

@Entity
public class Transacao extends EntidadeBanco implements Comparable<Transacao> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2085220597982994996L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transacao")
	private Long identificador;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@ManyToOne
	@JoinColumn(name = "id_conta_debito")
	private Conta contaDebito;

	@ManyToOne
	@JoinColumn(name = "id_conta_credito")
	private Conta contaCredito;

	private double valor;

	private String descricao;

	@Enumerated(EnumType.STRING)
	private EnumTipoTransacao tipoTransacao;

	public Transacao() {

	}

	public Transacao(Date data, Conta contaDebito, Conta contaCredito,
			double valor, String descricao, EnumTipoTransacao tipoTransacao) {

		this.data = data;
		this.contaDebito = contaDebito;
		this.contaCredito = contaCredito;
		this.valor = valor;
		this.descricao = descricao;
		this.tipoTransacao = tipoTransacao;
		}

	@Override
	public Long getIdentificador() {

		return identificador;
	}

	public void setIdentificador(Long identificador) {

		this.identificador = identificador;
	}

	public void setContaCredito(Conta contaCredito) {

		this.contaCredito = contaCredito;
	}

	public void setContaDebito(Conta contaDebito) {

		this.contaDebito = contaDebito;
	}

	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

	public void setValor(double valor) {

		this.valor = valor;
	}

	public Conta getContaCredito() {

		return contaCredito;
	}

	public Conta getContaDebito() {

		return contaDebito;
	}

	public Date getData() {

		return data;
	}

	public void setData(Date data) {

		this.data = data;
	}

	public String getDescricao() {

		return descricao;
	}

	public double getValor() {

		return valor;
	}

	public EnumTipoTransacao getTipoTransacao() {

		return tipoTransacao;
	}

	public void setTipoTransacao(EnumTipoTransacao tipoTransacao) {

		this.tipoTransacao = tipoTransacao;
	}

	public String toString() {

		if (EnumTipoTransacao.TRANSFERENCIA == getTipoTransacao()) {

			return "Transacao data " + UtilData.DDMMAAAAHHMM(getData())
					+ ", conta debito " + getContaDebito().getNumero()
					+ ", conta credito " + getContaCredito().getNumero()
					+ ", valor " + getValor() + ", descricao -> "
					+ getDescricao();

		} else if (EnumTipoTransacao.DEPOSITO == getTipoTransacao()) {

			return "Deposito data " + UtilData.DDMMAAAAHHMM(getData())
					+ ", conta " + getContaCredito().getNumero() + ", valor "
					+ getValor() + ", descricao -> " + getDescricao();

		} else if (EnumTipoTransacao.SAQUE == getTipoTransacao()) {

			return "Saque data " + UtilData.DDMMAAAAHHMM(getData())
					+ ", conta " + getContaCredito().getNumero() + ", valor "
					+ getValor() + ", descricao -> " + getDescricao();
		}

		return "Nenhum tipo de transação";
	}

	/**
	 * Permite comparações, usando para classificar
	 */
	public int compareTo(Transacao o) {

		// comparando somente campo nome
		return getData().compareTo(o.getData());
	}

	public String getDataFormatada() {

		return UtilData.formataData(getData());
	}
}
