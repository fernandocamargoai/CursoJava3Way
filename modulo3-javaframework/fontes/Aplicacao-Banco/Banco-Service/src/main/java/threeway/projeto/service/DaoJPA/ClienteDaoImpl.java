package threeway.projeto.service.DaoJPA;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.modelo.enums.EnumStatus;

public class ClienteDaoImpl extends DaoImpl<Cliente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1081947125480849486L;
	
	@Inject
	private EntityManager manager;

	@Override
	public Cliente obter(Serializable identificador) {

		Cliente resultado = null;

		resultado = (Cliente) this.getSession().get(Cliente.class,
				identificador);

		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Cliente> listar() {

		Criteria criteria = this.getSession().createCriteria(Cliente.class);
		
		criteria.add(Restrictions.eq("statusCliente", EnumStatus.ATIVO));

		return criteria.list();

	}

	@Override
	public EntityManager getEntityManager() {

		return this.manager;
	}

	public Cliente buscarClientePorCPF(String cpf) {

		Criteria criteria = this.getSession().createCriteria(Cliente.class);

		criteria.add(Restrictions.eq("cpf", cpf));

		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		return (Cliente) criteria.uniqueResult();
	}

}
