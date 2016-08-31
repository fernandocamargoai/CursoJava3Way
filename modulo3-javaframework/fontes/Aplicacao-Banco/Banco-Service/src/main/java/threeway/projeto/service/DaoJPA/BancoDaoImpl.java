package threeway.projeto.service.DaoJPA;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;

import threeway.projeto.modelo.Banco;

public class BancoDaoImpl extends DaoImpl<Banco> {

	@Inject
	private EntityManager manager;

	@Override
	public Banco obter(Serializable identificador) {

		Banco resultado = null;

		resultado = (Banco) this.getSession().get(Banco.class, identificador);

		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Banco> listar() {

		Criteria criteria = this.getSession().createCriteria(Banco.class);

		return criteria.list();
	}

	@Override
	public EntityManager getEntityManager() {

		return this.manager;
	}

}
