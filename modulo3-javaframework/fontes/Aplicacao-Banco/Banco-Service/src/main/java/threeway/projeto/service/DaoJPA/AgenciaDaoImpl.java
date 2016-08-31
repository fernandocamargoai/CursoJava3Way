package threeway.projeto.service.DaoJPA;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;

import threeway.projeto.modelo.Agencia;

public class AgenciaDaoImpl extends DaoImpl<Agencia> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8073044246034177000L;
	
	@Inject
	private EntityManager manager;

	@Override
	public Agencia obter(Serializable identificador) {

		Agencia resultado = null;

		resultado = (Agencia) this.getSession().get(Agencia.class, identificador);

		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Agencia> listar() {

		Criteria criteria = this.getSession().createCriteria(Agencia.class);

		return criteria.list();
	}

	@Override
	public EntityManager getEntityManager() {

		return this.manager;
	}

}
