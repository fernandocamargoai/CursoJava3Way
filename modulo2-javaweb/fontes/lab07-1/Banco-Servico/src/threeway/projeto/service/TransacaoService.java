package threeway.projeto.service;

import threeway.projeto.modelo.Transacao;
import threeway.projeto.service.Dao.TransacaoDao;

public class TransacaoService {

	TransacaoDao dao = new TransacaoDao();

	/**
	 * Método responsável por retornar instancia de TransacaoDao
	 *
	 * @author Wilker Machado
	 *
	 * @return TransacaoDao
	 */
	public TransacaoDao getDao() {

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

}
