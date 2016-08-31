package threeway.projeto.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import threeway.projeto.service.AgenciaService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends AppController {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		// recupera do form através do request o valor do input com o name login
		final String login = request.getParameter("login");
						
		// recupera do form através do request o valor do input com o name senha
		final String senha = request.getParameter("senha");		
						
		//Verifica se login e senha conferem, utilizaremos o login: admin e senha: admin como falores fixos.
		if (("admin".equals(login)) && "admin".equals(senha)){			
		
			final String cookieName = "usuario";
			
			final String cookieValue = login;
						
			//criando o objeto cookie
			Cookie cookie = new Cookie(cookieName, cookieValue);
			
			//duração de um dia
			cookie.setMaxAge(60*60*24);
			
			//adicionando o cookie ao navegador
			response.addCookie(cookie);		
						
			this.gerarLog("Realizou o Login");
			
			//Limpando o campo mensagem da sessão
			this.getRequest().getSession().setAttribute("msg", null);
			
			//adicionando o login do usuario na sessao
			this.getRequest().getSession().setAttribute("usuario", login);		
			
			//adicionando os campos agencia e banco na sessão
			this.getRequest().getSession().setAttribute("agencia", AgenciaService.agenciaSistema());
			
			//Esta funcionalidade será ensinada nas proximas aulas
			response.sendRedirect("index.jsp");
			
			
		}else{
			
			//caso digite o login e senha invalido
			this.getRequest().getSession().setAttribute("msg", "Dados do login inválido");

			//Esta funcionalidade será ensinada nas proximas aulas
			response.sendRedirect("login.jsp");
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	



}
