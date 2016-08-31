import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.modelo.Conta;
import threeway.projeto.modelo.Transacao;
import threeway.projeto.modelo.enums.EnumTipoConta;
import threeway.projeto.modelo.enums.EnumTipoTransacao;
import threeway.projeto.service.AgenciaService;
import threeway.projeto.service.ContaService;
import threeway.projeto.service.TransacaoService;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;
import threeway.projeto.service.excecoes.ContaNaoExisteException;
import threeway.projeto.service.excecoes.SaldoInsuficienteException;

@Named
@SessionScoped
public class OperacoesBancariasBean implements Serializable {

	private static final long serialVersionUID = -129503110150417090L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private AgenciaService agenciaService;

	@Inject
	private TransacaoService transacaoService;

	@Inject
	private ManterClienteBean clienteBean;

	@Inject
	private ContaService contaService;

	private Conta contaCliente;

	private Cliente clienteSelecionado;

	private boolean flagDialogAbrirConta;

	private boolean flagDialogDeposito;

	private boolean flagDialogSaque;

	private boolean flagDialogTransferencia;

	private Double valorDeposito;

	private Double valorSaque;

	private Double valorTransferencia;

	private int numeroContaTransferencia;

	private Collection<Transacao> transacoesConta;

	public String determinaCorLinhaTabela(Transacao transacao) {

		if (transacao.getTipoTransacao() == EnumTipoTransacao.DEPOSITO) {
			return "deposito";

		} else if (transacao.getTipoTransacao() == EnumTipoTransacao.SAQUE) {
			return "saque";

		} else {
			return "transferencia";
		}
	}

	public void inicializaOperacoesConta() {
		this.valorDeposito = 0.0;
		this.valorTransferencia = 0.0;
		this.valorSaque = 0D;
		this.contaCliente = this.contaService
				.buscaContaPorCliente(clienteSelecionado);

		if (this.contaCliente != null
				&& this.contaCliente.getIdentificador() != null) {

			this.setTransacoesConta(this.transacaoService
					.listarTransacoesPorConta(contaCliente.getIdentificador()));

		} else {
			// this.contaCliente = new Conta();
			this.setContaCliente(new Conta());
			this.getContaCliente().setTitular(clienteSelecionado);
			this.getContaCliente().setDataAbertura(new Date());
			this.getContaCliente().setTipoConta(EnumTipoConta.CONTA_PESSOAL);
			this.getContaCliente().setAgencia(AgenciaService.agenciaSistema());
		}
	}

	public String selecionaCliente(Cliente cliente) {

		this.setClienteSelecionado(cliente);

		this.inicializaOperacoesConta();

		return "operacoesBancarias";
	}

	public void abrirConta() {

		try {
			this.contaService.salvar(this.getContaCliente());
			this.inicializaOperacoesConta();
			this.flagDialogAbrirConta = Boolean.FALSE;

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Sucesso",
					"Abertura de conta concluída!"));
		} catch (CamposObrigatoriosException e) {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "ERRO", e.getMessage()));
		}
	}

	public void efetuarDeposito() {
		if (valorDeposito != null && valorDeposito > 0) {
			this.contaService.depositar(contaCliente, valorDeposito);
			this.inicializaOperacoesConta();

			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Sucesso",
					"Deposito realizado com sucesso"));
		} else {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro.",
					"Valor válido não informado!"));
		}
	}

	public void efetuarSaque() {
		if (valorSaque != null && valorSaque > 0) {

			try {
				this.contaService.sacar(contaCliente, valorSaque);
				this.inicializaOperacoesConta();

				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "sucesso",
						"Saque realizado com sucesso!"));

			} catch (SaldoInsuficienteException e) {
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erro.", e.getMessage()));
			}
		} else {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro.",
					"Valor válido não informado"));
		}
	}

	public void realizarTransferencia() {
		if (valorTransferencia != null && valorTransferencia > 0) {

			try {
				Conta contaDestinoTransferencia = this.contaService
						.buscaContaPorNumero(this.numeroContaTransferencia);

				this.contaCliente = this.contaService
						.buscaContaPorNumero(this.contaCliente.getNumero());
				this.contaService.transferir(contaCliente, valorTransferencia,
						contaDestinoTransferencia);
				this.inicializaOperacoesConta();

				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_INFO, "Sucesso",
						"Transferência realiaza com sucesso!"));

			} catch (ContaNaoExisteException ex) {
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erro.", ex.getMessage()));

			} catch (SaldoInsuficienteException e) {
				facesContext.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Erro.", e.getMessage()));

			}

		} else {
			facesContext.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro.",
					"Valor válido não informado!"));

		}

	}

	// getters setters

	public TransacaoService getTransacaoService() {
		return transacaoService;
	}

	public void setTransacaoService(TransacaoService transacaoService) {
		this.transacaoService = transacaoService;
	}

	public Double getValorDeposito() {
		return valorDeposito;
	}

	public boolean isFlagDialogAbrirConta() {
		return flagDialogAbrirConta;
	}

	public void setFlagDialogAbrirConta(boolean flagDialogAbrirConta) {
		this.flagDialogAbrirConta = flagDialogAbrirConta;
	}

	public boolean isFlagDialogDeposito() {
		return flagDialogDeposito;
	}

	public void setFlagDialogDeposito(boolean flagDialogDeposito) {
		this.flagDialogDeposito = flagDialogDeposito;
	}

	public boolean isFlagDialogSaque() {
		return flagDialogSaque;
	}

	public void setFlagDialogSaque(boolean flagDialogSaque) {
		this.flagDialogSaque = flagDialogSaque;
	}

	public boolean isFlagDialogTransferencia() {
		return flagDialogTransferencia;
	}

	public void setFlagDialogTransferencia(boolean flagDialogTransferencia) {
		this.flagDialogTransferencia = flagDialogTransferencia;
	}

	public void setValorDeposito(Double valorDeposito) {
		this.valorDeposito = valorDeposito;
	}

	public Double getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(Double valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public int getNumeroContaTransferencia() {
		return numeroContaTransferencia;
	}

	public void setNumeroContaTransferencia(int numeroContaTransferencia) {
		this.numeroContaTransferencia = numeroContaTransferencia;
	}

	public Collection<Transacao> getTransacoesConta() {

		if (transacoesConta == null || transacoesConta.isEmpty()) {

			transacoesConta = new ArrayList<Transacao>();
		}

		return transacoesConta;
	}

	public void setTransacoesConta(Collection<Transacao> transacoesConta) {
		this.transacoesConta = transacoesConta;
	}

	public Conta getContaCliente() {

		if (contaCliente == null) {

			contaCliente = new Conta();
		}

		return contaCliente;
	}

	public void setContaCliente(Conta contaCliente) {
		this.contaCliente = contaCliente;
	}

	public Cliente getClienteSelecionado() {

		if (clienteSelecionado == null) {

			clienteSelecionado = new Cliente();
		}
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public ManterClienteBean getClienteBean() {
		return clienteBean;
	}

	public Double getValorSaque() {
		return valorSaque;
	}

	public void setValorSaque(Double valorSaque) {
		this.valorSaque = valorSaque;
	}

	/**
	 * @return the agenciaService
	 */
	public AgenciaService getAgenciaService() {
		return agenciaService;
	}

	/**
	 * @param agenciaService
	 *            the agenciaService to set
	 */
	public void setAgenciaService(AgenciaService agenciaService) {
		this.agenciaService = agenciaService;
	}
}
