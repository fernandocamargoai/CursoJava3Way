package threeway.projeto.service.DaoJPA;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtil {

	private  EntityManagerFactory factory;

	public JPAUtil() {

		this.factory = Persistence.createEntityManagerFactory("Banco-ServicePU");
	}
	
//	public static EntityManager getEntityManager() {
//		return factory.createEntityManager();
//	}

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {

		return factory.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {

		manager.close();
	}
}
