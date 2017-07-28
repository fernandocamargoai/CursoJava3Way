package br.com.threeway.locadora.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	public static final boolean DEBUG = true;

	private static final PersistenceManager SINGLETON =
			new PersistenceManager();

	private EntityManagerFactory emf;

	private PersistenceManager() {
	}

	public static PersistenceManager getInstance() {

		return SINGLETON;
	}

	public EntityManagerFactory getEntityManagerFactory() {

		return emf;
	}

	public void closeEntityManagerFactory() {

		if (emf != null) {
			emf.close();
			emf = null;
			if (DEBUG)
				System.out.println("Persistence finished at " +
						new java.util.Date());
		}
	}

	public void createEntityManagerFactory() {

		this.emf = Persistence.createEntityManagerFactory("locadorapu");
		if (DEBUG)
			System.out.println("Persistence started at " +
					new java.util.Date());
	}
}
