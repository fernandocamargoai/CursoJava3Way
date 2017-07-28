package br.com.threeway.locadora.web;

import br.com.threeway.locadora.dao.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceAppListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent evt) {
		PersistenceManager.getInstance().createEntityManagerFactory();
	}


	public void contextDestroyed(ServletContextEvent evt) {
		PersistenceManager.getInstance().closeEntityManagerFactory();
	}
}
