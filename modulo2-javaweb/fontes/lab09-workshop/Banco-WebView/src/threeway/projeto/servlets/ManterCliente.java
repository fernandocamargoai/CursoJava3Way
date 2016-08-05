package threeway.projeto.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.service.ClienteService;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;


public class ManterCliente extends AppController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClienteService service;
	private Cliente cliente;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			
		String action = req.getParameter("action");
		
		cliente.setNome(req.getParameter("nome"));
		cliente.setEndereco(req.getParameter("endereco"));
		cliente.setRg(req.getParameter("rg"));
		cliente.setTelefone(req.getParameter("cpf"));
		
		if("salvar".equals(action)) {
			 salvarCliente();			
			this.gerarLog("Cadastro do Cliente: " + cliente.getNome() + ", RG:" + cliente.getRg());
			req.getSession().setAttribute("cliente", null);
			
		} else 	if("alterar".equals(action)) {				
				alterarCliente();
				this.gerarLog("Alteração do Cliente: " + cliente.getNome() + ", RG: " + cliente.getRg());
				req.getSession().setAttribute("cliente", null);
				
		} else 	if("carregar".equals(action)) {
					cliente = service.buscarClientePorCPF(req.getParameter("cpf"));
					req.getSession().setAttribute("cliente", cliente);
					
		} else if ("excluir".equals(action)) {
					excluirCliente(cliente);			
					req.getSession().setAttribute("cliente", null);
					
		} else {
				req.getSession().setAttribute("cliente", null);
				req.getSession().setAttribute("msg", null);
				req.getSession().setAttribute("conta", null);
				}
		req.getSession().setAttribute("listaClientes", service.listarTodosClientes());
		resp.sendRedirect("manterCliente.jsp");
			
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		if(cliente == null) {
			cliente = new Cliente();
		}
		if(service == null) {
			service = new ClienteService();
		}
	}
	
	private void salvarCliente() {
		
		try {
			service.salvar(cliente);
			this.exibirMensagem("Ação realizada com sucesso!");
		} catch (CamposObrigatoriosException e) {
			this.exibirMensagem("Preencha os campos obrigatórios!");
		}
	}
	
	private void alterarCliente() {
		
		try {
			service.atualizar(cliente);
			this.exibirMensagem("Ação realizada com sucesso!");
		} catch (CamposObrigatoriosException e) {
			this.exibirMensagem("Preencha os campos obrigatórios!");
		}
	}
	
	private void excluirCliente(Cliente cliente) {
		
		service.excluir(cliente);
		this.exibirMensagem("Ação realizada com sucesso");
	}

	public ClienteService getService() {
		return service;
	}

	public void setService(ClienteService service) {
		this.service = service;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
