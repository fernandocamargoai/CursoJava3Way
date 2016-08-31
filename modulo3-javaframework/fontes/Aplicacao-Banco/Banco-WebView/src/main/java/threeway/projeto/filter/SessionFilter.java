package threeway.projeto.filter;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter(filterName="/SessionFilter", urlPatterns={"/index.jsp", "/manterCliente.jsp", "/operacoesBancarias.jsp" })
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("Ola, o filtro de verificar sessão esta ativo!");
		
		HttpServletRequest req = (HttpServletRequest) request;

		HttpServletResponse resp = (HttpServletResponse) response;
		
		String usuarioSession = (String) req.getSession().getAttribute("usuario");

		if (usuarioSession == null || usuarioSession.isEmpty()) {			
			
			resp.sendRedirect("login.jsp");
			
		} else {
			
			gerarLogTxt(req);

			chain.doFilter(request, response);
		}
	}

	private void gerarLogTxt(final HttpServletRequest request) {
				
		try {								
			FileWriter arquivo = null;
			
			//obtem o diretório mapeado no web.xml, esse diretorio esta no contexto da aplicação pode ser recupearado
			//em qualquer lugar a através do getServletContext();
			String diretorio = (String) request.getServletContext().getInitParameter("dirLog");
			
			//Criar um arquivo com o nome acess-log.txt dentro do diretorio mapeado no web.xml
			arquivo = new FileWriter(diretorio + "acess-log.txt",true);		
			
			//Criar o objeto para a escrita dentro do arquivo acess-log
			PrintWriter escreverFile = new PrintWriter(arquivo);
						
			//escreve a string dentro do arquivo acess-log
			escreverFile.printf("[Data|Url Requisitada|Ip solicitante]: "
					+ new Date() + " | " + request.getRequestURI() + " | " + request.getRemoteAddr() + "\n");
			
			arquivo.close(); 
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
