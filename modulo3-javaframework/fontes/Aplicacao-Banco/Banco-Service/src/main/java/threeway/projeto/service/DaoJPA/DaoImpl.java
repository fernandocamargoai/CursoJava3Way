package threeway.projeto.service.DaoJPA;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import threeway.projeto.modelo.EntidadeBanco;
import threeway.projeto.service.Dao.Dao;

public abstract class DaoImpl<E extends EntidadeBanco> implements Dao<E>,
		Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6511394566644536118L;

	@Override
	public void alterar(E entidade) {

		this.getSession().update(entidade);

		this.getSession().flush();

	}

	@Override
	public void salvar(E entidade) {

		this.getSession().save(entidade);

		this.getSession().flush();

	}
	@Override
	public void remover(E entidade) {
//		
//		if (!this.getEntityManager().contains(entidade)) {
//			
//			entidade = this.getEntityManager().merge(entidade);
//			
//		} 			
//
//		this.getSession().delete(entidade);	
//		
//		this.getSession().flush();

	}

	public abstract EntityManager getEntityManager();

	public Session getSession() {

		try {

			return (Session) getEntityManager().getDelegate();

		} catch (Exception e) {

			return null;
		}
	}

}
