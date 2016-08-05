package threeway.projeto.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import threeway.projeto.modelo.Log;

public class AppController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;


	private HttpServletResponse response;
	private Log log;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			this.request = request;
			this.response = response;
			
			super.service(request, response);
	}
	
	public void gerarLog(final String descricao) {
		
		List<Log> logsAnteriores = (List<Log>)this.getRequest().getSession().getAttribute("dadosLog");
		
		if (logsAnteriores == null || logsAnteriores.isEmpty()) {
			logsAnteriores = new ArrayList<Log>();
		}
		
		this.getLog().setDescricao(descricao);
		this.getLog().setData(new Date());
		
		logsAnteriores.add(this.getLog());
		this.getRequest().getSession().setAttribute("dadosLog", logsAnteriores);
	}
	
	protected void exibirMensagem(final String mensagem) {
		this.request.getSession().setAttribute("msg", mensagem);
	}
	
	
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Log getLog() {
		if(log == null) {
			log = new Log();
		}
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

}
