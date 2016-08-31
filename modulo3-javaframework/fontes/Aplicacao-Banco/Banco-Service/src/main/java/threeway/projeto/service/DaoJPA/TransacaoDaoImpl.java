package threeway.projeto.service.DaoJPA;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import threeway.projeto.modelo.Transacao;

public class TransacaoDaoImpl extends DaoImpl<Transacao> {

	@Inject
	private EntityManager manager;

	@Override
	public Transacao obter(Serializable identificador) {

		Transacao resultado = null;

		resultado = (Transacao) this.getSession().get(Transacao.class, identificador);

		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Transacao> listar() {

		Criteria criteria = this.getSession().createCriteria(Transacao.class);

		return criteria.list();
	}

	@Override
	public EntityManager getEntityManager() {

		return this.manager;
	}

	@SuppressWarnings("unchecked")
	public Collection<Transacao> listarTransacoesPorConta(Long identificador) {

		Criteria criteria = this.getSession().createCriteria(Transacao.class);

		criteria.createAlias("contaDebito", "contaDebito", JoinType.LEFT_OUTER_JOIN);

		criteria.createAlias("contaCredito", "contaCredito", JoinType.LEFT_OUTER_JOIN);
		
		criteria.add(Restrictions.or(Restrictions.eq("contaCredito.identificador", identificador), 
				Restrictions.eq("contaDebito.identificador", identificador)));

		return criteria.list();
	}

}
