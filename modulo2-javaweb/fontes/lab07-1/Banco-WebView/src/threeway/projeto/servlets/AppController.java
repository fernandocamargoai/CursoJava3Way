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

public class AppController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
		//Criando um atributo referente a interface HttpServletRequest
		private HttpServletRequest request;
		
		//Criando um atributo referente a interface HttpServletResponse
		private HttpServletResponse response;
		
		//Criando um atributo referente a classe de modelo Log
		private Log log;

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			//atribui o objeto request ao atributo request que criamos acima
			this.request = req;
			
			//atribuit o objeto response ao atributo response que criamos acima
			this.response = resp;
			
			//chama metodo service da classe pai
			super.service(request, response);
		}
		
		public void gerarLog(final String descricao){

			//obtém a lista de logs já existentes
					List<Log> logsAnteriores = (List<Log>) this.getRequest().getSession().getAttribute("dadosLog");
					
					// verifica se essa lista de logs está vazia, se estiver ela é e inicializada com
					// a instância de um ArrayList
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

		public Log getLog() {
			
			if (log == null) {
				log = new Log();
			}
			return log;
		}

		public void setLog(Log log) {
			this.log = log;
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
	
	
	

}
