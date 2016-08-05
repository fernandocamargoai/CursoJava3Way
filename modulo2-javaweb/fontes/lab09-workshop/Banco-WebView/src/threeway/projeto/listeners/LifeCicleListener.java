package threeway.projeto.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LifeCicleListener
 *
 */
@WebListener
public class LifeCicleListener implements HttpSessionListener, ServletContextListener, ServletContextAttributeListener{

    /**
     * Default constructor. 
     */
    public LifeCicleListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent hse)  { 
         System.out.println("Sessão cirada!");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent hse)  { 
         System.out.println("Sessão destruida!");
    }

	@Override
	public void attributeAdded(ServletContextAttributeEvent sca) {
		System.out.println("Atributo criado: " + sca.getServletContext().getInitParameter("dirLog"));
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("O conteiner foi parado!");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("O conteiner foi inicializado!");
		System.out.println("Nome do Servidor: " + sce.getServletContext().getServerInfo());
		
	}
	
}
