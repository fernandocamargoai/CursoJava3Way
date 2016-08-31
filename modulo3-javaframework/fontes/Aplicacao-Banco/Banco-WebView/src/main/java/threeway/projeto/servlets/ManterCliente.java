package threeway.projeto.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.service.ClienteService;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;

/**
 * Servlet implementation class ManterCliente
 */
public class ManterCliente extends AppController {
    
	@Inject
	private ClienteService service;
	
	Cliente cliente;
    /**
	 * 
	 */
	private static final long serialVersionUID = -5611562420956748465L;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//verifica se o objeto cliente � igual a null, se sim cria uma instancia para ele
		if (cliente == null){
		
			cliente = new Cliente();		
		}
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		cliente.setNome(request.getParameter("nome"));
		cliente.setEndereco(request.getParameter("endereco"));
		cliente.setRg(request.getParameter("rg"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setCpf(request.getParameter("cpf"));
						
		if ("salvar".equals(action)){
			
			salvarCliente();
			
			this.gerarLog("Cadastro do Cliente: " + cliente.getNome() + ", Rg:" + cliente.getRg());
			
			request.getSession().setAttribute("cliente", null);
		
		}else 
			if ("alterar".equals(action)){
				
			alterarCliente();
				
			this.gerarLog("Altera��o do Cliente: " + cliente.getNome() + ", Rg:" + cliente.getRg());
			
			request.getSession().setAttribute("cliente", null);
			
		}else
			if ("carregar".equals(action)){
				
				cliente = service.buscarClientePorCPF(request.getParameter("cpf"));
				//joga os dados do cliente selecionado na sess�o para carregar no formulario
				request.getSession().setAttribute("cliente", cliente);
			
		}else
			if("excluir".equals(action)){
					
				excluirCliente();
				
				request.getSession().setAttribute("cliente", null);
		}else{
			request.getSession().setAttribute("cliente", null);
			request.getSession().setAttribute("msg", null);				
			request.getSession().setAttribute("conta", null);
					
		}
		
		//joga na sess�o a lista de Clientes Cadastrados
		request.getSession().setAttribute("listaClientes", service.listarTodosClientes());			
		
		response.sendRedirect("manterCliente.jsp");
	}

	
	
	private void salvarCliente(){
		
		try {			
			
			service.salvar(cliente);
			
			this.exibirMensagem("A��o realizada com sucesso!");
			
		} catch (CamposObrigatoriosException e) {
			
			this.exibirMensagem("Preencha os campos obrigatorios!");
			
		}
	}
	
	private void alterarCliente(){
		
		try {
			
			service.atualizar(cliente);
			
			this.exibirMensagem("A��o realizada com sucesso!");
			
		} catch (CamposObrigatoriosException e) {
			
			this.exibirMensagem("Preencha os campos obrigatorios!");
		}
	}
	
	private void excluirCliente(){
			
		service.excluir(cliente);		
		
		this.exibirMensagem("A��o realizada com sucesso!");
		
	}
    
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}