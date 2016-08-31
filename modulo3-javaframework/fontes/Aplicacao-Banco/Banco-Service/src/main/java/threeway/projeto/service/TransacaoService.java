package threeway.projeto.service;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import threeway.projeto.modelo.Transacao;
import threeway.projeto.service.DaoJPA.TransacaoDaoImpl;

public class TransacaoService implements Serializable{

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1901649352964084473L;
	
	@Inject
	private TransacaoDaoImpl dao;

	/**
	 * Método responsável por retornar instancia de TransacaoDao
	 *
	 * @author Wilker Machado
	 *
	 * @return TransacaoDao
	 */
	public TransacaoDaoImpl getDao() {

		return dao;
	}

	/**
	 * Método responsável por por salvar a entidade transação
	 *
	 * @author Wilker Machado
	 *
	 * @param transacao
	 */
	public void salvar(Transacao transacao) {

		this.getDao().salvar(transacao);		
	}

	/**
	 * Método responsável por listar as transações de determinada conta
	 *
	 * @author Wilker Machado
	 *
	 * @param identificador
	 * 
	 * @return Collection<Transacao>
	 */
	public Collection<Transacao> listarTransacoesPorConta(Long identificador) {

		return dao.listarTransacoesPorConta(identificador);
	}

}
