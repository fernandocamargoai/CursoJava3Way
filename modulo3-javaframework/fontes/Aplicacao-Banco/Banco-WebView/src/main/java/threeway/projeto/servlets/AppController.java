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

@SuppressWarnings("unchecked")
public class AppController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4229570440441457625L;

	//Criando um atributo referente a interface HttpServletRequest
	private HttpServletRequest request;
	
	//Criando um atributo referente a interface HttpServletResponse
	private HttpServletResponse response;
	
	//Criando um atributo referente a classe de modelo Log
	private Log log;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//atribuit o objeto req ao atributo request que criamos acima
		this.request = request;
		
		//atribuit o objeto resp ao atributo response que criamos acima
		this.response = response;
		
		//chama metodo service da classe pai
		super.service(request, response);
	}
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public void gerarLog(final String descricao){

		//obtem a lista de logs ja exisentes
		List<Log> logsAnteriores = (List<Log>) this.getRequest().getSession().getAttribute("dadosLog");
		
		// verifica se essa lista de logs esta vazia se estiver ela é e inicializada com
		// a instancia de um ArrayList
		if (logsAnteriores == null || logsAnteriores.isEmpty()){
			
			logsAnteriores = new ArrayList<Log>();
		}
		
		//Monta a descrição do log
		this.getLog().setDescricao(descricao);
		
		//Monta a data que o log foi gerado
		this.getLog().setData(new Date());
		
		//Adiciona o novo log a lista de logs existentes
		logsAnteriores.add(this.getLog());
		
		//coloca a lista de logs anteriores como o novo log gerado na sessão novamente.		
		this.getRequest().getSession().setAttribute("dadosLog", logsAnteriores);
	}
	
	
	protected void exibirMensagem(final String mensagem){
		
		this.request.getSession().setAttribute("msg", mensagem);
	}
	


	/**
	 * @return the log
	 */
	public Log getLog() {
		
		//verifica se o objeto log esta nulo, caso sim cria uma instancia do objeto Log
		if (log == null){
			
			log = new Log();
		}
		return log;
	}

	/**
	 * @param logs the logs to set
	 */
	public void setLog(Log log) {
		this.log = log;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}


}
