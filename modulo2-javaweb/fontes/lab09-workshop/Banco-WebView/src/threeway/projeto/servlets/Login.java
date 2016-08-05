package threeway.projeto.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import threeway.projeto.service.AgenciaService;

public class Login extends AppController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
			doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		final String login = req.getParameter("login");
		final String senha = req.getParameter("senha");
		
		if ("admin".equals(login) && "admin".equals(senha)) {
			
			final String cookieName = "usuario";
			final String cookieValue = login;		
			
			Cookie cookie = new Cookie(cookieName, cookieValue);
			cookie.setMaxAge(60*60*24);
			
			Cookie cookieExemplo = new Cookie("senha", senha);
			cookie.setMaxAge(60*60*24);
			
			resp.addCookie(cookie);
			resp.addCookie(cookieExemplo);
			
			this.gerarLog("Realizou Login");
			this.getRequest().getSession().setAttribute("msg", null);
			this.getRequest().getSession().setAttribute("usuario", login);
			this.getRequest().getSession().setAttribute("agencia", AgenciaService.agenciaSistema());
			
			resp.sendRedirect("index.jsp");
		} else {
			this.getRequest().getSession().setAttribute("msg", "Dados do login inválido");
			resp.sendRedirect("login.jsp");
		}
	}

}
