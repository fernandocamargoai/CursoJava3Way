package threeway.projeto.service.DaoJPA;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;

import threeway.projeto.modelo.Conta;


public class ContaDaoImpl extends DaoImpl<Conta> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -880601079831324727L;
	
	@Inject
	private EntityManager manager;

	@Override
	public Conta obter(Serializable identificador) {

		Conta resultado = null;

		resultado = (Conta) this.getSession().get(Conta.class, identificador);

		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Conta> listar() {

		Criteria criteria = this.getSession().createCriteria(Conta.class);

		return criteria.list();
	}

	@Override
	public EntityManager getEntityManager() {

		return this.manager;
	}
}
