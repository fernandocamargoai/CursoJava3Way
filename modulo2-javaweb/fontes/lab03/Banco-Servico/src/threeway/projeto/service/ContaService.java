package threeway.projeto.service;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.modelo.Conta;
import threeway.projeto.modelo.Transacao;
import threeway.projeto.modelo.enums.EnumTipoTransacao;
import threeway.projeto.modelo.util.UtilData;
import threeway.projeto.service.Dao.ContaDao;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;
import threeway.projeto.service.excecoes.ContaNaoExisteException;
import threeway.projeto.service.excecoes.SaldoInsuficienteException;

public class ContaService {

	private ContaDao dao = new ContaDao();

	private TransacaoService transacaoService = new TransacaoService();

	/**
	 * Método responsável por realizar ação de deposito
	 * 
	 * @author Wilker Machado
	 * 
	 * @param contaDestino
	 * 
	 * @param valor
	 */
	public void depositar(Conta contaDestino, double valor) {

		contaDestino.setSaldo(contaDestino.getSaldo() + valor);

		this.historicoTransacao(null, contaDestino, valor, "deposito na conta " + contaDestino.getNumero(), EnumTipoTransacao.DEPOSITO);
	}

	/**
	 * Método responsável por realizar ação de saque caso não tenha saldo suficiente e lançado uma exceção
	 * 
	 * @author Wilker Machado
	 * 
	 * @param contaSaque
	 * 
	 * @param valor
	 * 
	 * @throws SaldoInsuficienteException 
	 */
	public void sacar(Conta contaSaque, double valor) throws SaldoInsuficienteException {

		if (contaSaque.getSaldo() - valor >= 0) {

			contaSaque.setSaldo(contaSaque.getSaldo() - valor);

			this.historicoTransacao(null, contaSaque, valor, "saque na conta " + contaSaque.getNumero(), EnumTipoTransacao.SAQUE);

		} else {

			throw new SaldoInsuficienteException();
		}
	}

	/**
	 * Método responsável por realizar transferencia entre contas caso não tenha saldo suficiente e lançado uma exceção
	 * 
	 * @author Wilker Machado
	 * 
	 * @param contaSaque
	 * 
	 * @param valor
	 * 
	 * @param contaDestino
	 * 
	 * @return boolean true se a transferencia for realizada com sucesso
	 * 
	 * @throws SaldoInsuficienteException
	 */
	public boolean transferir(Conta contaSaque, double valor, Conta contaDestino) throws SaldoInsuficienteException {

		return transferir(contaSaque, valor, contaDestino, "transferencia para conta " + contaDestino.getNumero());
	}

	/**
	 * Método responsável por realizar transferencia entre contas caso não tenha saldo suficiente e lançado uma exceção
	 * 
	 * @author Wilker Machado
	 * 
	 * @param contaSaque
	 * 
	 * @param valor
	 * 
	 * @param contaDestino
	 * 
	 * @param descr
	 * 
	 * @return boolean true se a transferencia for realizada com sucesso
	 * 
	 * @throws SaldoInsuficienteException
	 * 
	 */
	public boolean transferir(Conta contaSaque, double valor, Conta contaDestino, String descr) throws SaldoInsuficienteException {

		if (contaSaque.getSaldo() - valor >= 0) {

			this.debito(contaSaque, valor);

			this.credito(contaDestino, valor);

			this.historicoTransacao(contaSaque, contaDestino, valor, descr, EnumTipoTransacao.TRANSFERENCIA);

			return true;

		} else {

			throw new SaldoInsuficienteException();
		}

	}

	/**
	 * Método responsável por realizar debitos na conta
	 * 
	 * @author Wilker Machado
	 * 
	 * @param contaOperacao
	 * 
	 * @param valor
	 */
	protected void debito(Conta contaOperacao, double valor) {

		contaOperacao.setSaldo(contaOperacao.getSaldo() - valor);

	}

	/**
	 * Método responsável por realizar operações de credito na conta
	 * 
	 * @author Wilker Machado
	 * 
	 * @param contaOperacao
	 * 
	 * @param valor
	 */
	protected void credito(Conta contaOperacao, double valor) {

		contaOperacao.setSaldo(contaOperacao.getSaldo() + valor);

	}

	/**
	 * Método responsável por instanciar e gravar historico de transações
	 * 
	 * @author Wilker Machado
	 * 
	 * @param contaDebito
	 * 
	 * @param contaCredito
	 * 
	 * @param valor
	 * 
	 * @param descr
	 * 
	 * @param tipoTransacao
	 */
	protected void historicoTransacao(Conta contaDebito, Conta contaCredito, double valor, String descr, EnumTipoTransacao tipoTransacao) {

		Transacao transacao = new Transacao(UtilData.data(), contaDebito, contaCredito, valor, descr, tipoTransacao);

		if (contaDebito != null) {

			contaDebito.getTransacoes().add(transacao);

		}

		contaCredito.getTransacoes().add(transacao);

		transacaoService.salvar(transacao);
	}

	/**
	 * Método responsável por salvar entidade conta validando campos obrigatorios
	 * 
	 * @author Wilker Machado
	 * 
	 * @param conta
	 * 
	 * @throws CamposObrigatoriosException
	 */
	public void salvar(Conta conta) throws CamposObrigatoriosException {

		this.validarCamposObrigatorios(conta);

		this.getDao().salvar(conta);

	}

	/**
	 * Método responsável por validar campos obrigatorios
	 * 
	 * @author Wilker Machado
	 * 
	 * @param conta
	 * 
	 * @throws CamposObrigatoriosException
	 */
	private void validarCamposObrigatorios(Conta conta) throws CamposObrigatoriosException {

		if (conta == null || conta.getTitular() == null || conta.getNumero() == 0) {

			throw new CamposObrigatoriosException();
		}
	}

	/**
	 * Método responsável por buscar conta pelo cliente
	 * 
	 * @author Wilker Machado
	 * 
	 * @param cliente
	 * 
	 * @return Conta
	 */
	public Conta buscaContaPorCliente(Cliente cliente) {

		for (Conta conta : getDao().listar()) {

			if (conta.getTitular().equals(cliente)) {

				return conta;

			}
		}

		return null;
	}

	/**
	 * Método responsável por buscar conta por numero caso nao exista lança exceção de ContaNaoExisteException
	 * 
	 * @author Wilker Machado
	 * 
	 * @param numeroConta
	 * 
	 * @return Conta
	 * 
	 * @throws ContaNaoExisteException
	 */
	public Conta buscaContaPorNumero(int numeroConta) throws ContaNaoExisteException {

		for (Conta conta : getDao().listar()) {

			if (conta.getNumero() == numeroConta) {

				return conta;

			}
		}

		throw new ContaNaoExisteException();
	}

	/**
	 * Método responsável por retornar instancia de ContaDao
	 * 
	 * @author Wilker Machado
	 * 
	 * @return
	 */
	public ContaDao getDao() {

		return dao;
	}
}
