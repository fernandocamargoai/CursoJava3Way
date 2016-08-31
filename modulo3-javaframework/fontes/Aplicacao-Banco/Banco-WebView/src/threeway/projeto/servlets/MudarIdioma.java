package threeway.projeto.servlets;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;


@WebServlet("/MudarIdioma")
public class MudarIdioma extends AppController{

	/***/
	private static final long serialVersionUID = -281823556079676516L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Recupera a linguagem selecionada na tela
		final String locale = request.getParameter("linguagem");
		
		//Definindo o locale		
		Config.set(request.getSession(), Config.FMT_LOCALE, locale);
				
		response.sendRedirect("index.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		
		doGet(request, response);
	}
}
