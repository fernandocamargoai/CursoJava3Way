package threeway.projeto.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class LifeCicleListener implements ServletContextListener, ServletContextAttributeListener, HttpSessionListener {

  
    public LifeCicleListener() {
        // TODO Auto-generated constructor stub
    }


    public void contextInitialized(ServletContextEvent sce) {
     
    	System.out.println("O conteiner foi inicializado!");
    	
    	System.out.println("Nome do Servidor: "+ sce.getServletContext().getServerInfo());
    }

    public void contextDestroyed(ServletContextEvent arg0) { 
    	
    	System.out.println("O conteiner foi paralizado!");
    }
    
    @Override
	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("Sessão criada!");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("Sessão Destruida!");
	}
	
    public void attributeAdded(ServletContextAttributeEvent sca) {
    	
    	System.out.println("Atributo Criado " + sca.getServletContext().getInitParameter("dirLog"));
    }
	
    public void attributeReplaced(ServletContextAttributeEvent sca) {}

    public void attributeRemoved(ServletContextAttributeEvent sca) {}
	

	
	
}
