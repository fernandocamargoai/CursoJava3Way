package threeway.projeto.servlets;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(filterName="/SessionFilter", urlPatterns={"/index.jsp", "/manterCliente.jsp", "/operacoesBancarias.jsp"})
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Ola, o filtro de verificação está ativo!");
		

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String usuarioSession = null;
		
		Cookie cookies[]  = req.getCookies();
		
		for (Cookie cookieUsuario : cookies) {
			if(cookieUsuario.getName().equals("usuario")) {
				 usuarioSession = cookieUsuario.getValue();
			}
		}
		
		
		if (usuarioSession == null || usuarioSession.isEmpty()) {
			
			System.out.println("Você não está logado, não pode acessar a página" + req.getRequestURI());
			
			resp.sendRedirect("login.jsp");
		} else {
			
			chain.doFilter(request, response);
		}
		gerarLogTxt(req);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	private void gerarLogTxt(final HttpServletRequest request) {
		try {
			FileWriter arquivo = null;
			String diretorio = (String)request.getServletContext().getInitParameter("dirLog");
			arquivo = new FileWriter(diretorio + "access-log.txt", true);
			PrintWriter escreveFile = new PrintWriter(arquivo);
			escreveFile.printf("[Data|Url Requisitada|lp solicitante]:" + new Date() + "|" + request.getRequestURI() + "|" + request.getRemoteAddr() + "\n");
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
