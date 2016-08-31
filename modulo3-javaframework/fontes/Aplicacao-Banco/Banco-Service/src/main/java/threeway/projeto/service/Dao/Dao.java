package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.util.Collection;

import threeway.projeto.modelo.Entidade;

public interface Dao<E extends Entidade> {

	/**
	 * Busca a entidade pelo seu identificador.
	 * 
	 * @param identificador da entidade
	 * 
	 * @return Entidade pesquisada
	 */
	E obter(final Serializable identificador);

	/**
	 * Altera a entidade.
	 * 
	 * @param entidade
	 */
	void alterar(final E entidade);

	/**
	 * Insere a entidade.
	 * 
	 * @param entidade
	 */
	void salvar(final E entidade);
	
	/**
	 * Remove a entidade.
	 * 
	 * @param entidade
	 */
	void remover(final E entidade);

	/**
	 * Lista todos os objetos da entidade.
	 * 
	 * @return Collection<E>
	 */
	Collection<E> listar();
}
