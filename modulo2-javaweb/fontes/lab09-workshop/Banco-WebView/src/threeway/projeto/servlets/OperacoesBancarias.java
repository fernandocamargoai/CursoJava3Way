package threeway.projeto.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import threeway.projeto.modelo.Agencia;
import threeway.projeto.modelo.Cliente;
import threeway.projeto.modelo.Conta;
import threeway.projeto.modelo.enums.EnumTipoConta;
import threeway.projeto.modelo.util.UtilData;
import threeway.projeto.service.ContaService;
import threeway.projeto.service.TransacaoService;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;

/**
 * Servlet implementation class OperacoesBancarias
 */
@WebServlet("/OperacoesBancarias")
public class OperacoesBancarias extends AppController {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperacoesBancarias() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private Conta conta;
    private ContaService contaService;
    private TransacaoService transacaoService;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente clienteSession = (Cliente) request.getSession().getAttribute("cliente");
		Conta contaSession = (Conta) request.getSession().getAttribute("conta");
		
		if (contaSession == null) {
			request.getSession().setAttribute("conta", contaService.buscaContaPorCliente(clienteSession));
		}
		
		Double valor = null;
		String action = request.getParameter("action");
		
		if ("abrirConta".equals(action)) {
			conta.setDataAbertura(new Date());
			conta.setSaldo(Double.valueOf(request.getParameter("saldoInicial")));
			conta.setNumero(Integer.valueOf(request.getParameter("numero")));
			conta.setTitular(clienteSession);
			conta.setAgencia((Agencia)request.getSession().getAttribute("agencia"));
			conta.setTipoConta(EnumTipoConta.CONTA_PESSOAL);
			abrirConta();
			request.getSession().setAttribute("conta", contaService.buscaContaPorCliente(clienteSession));
		}
		
		request.getSession().setAttribute("dataFormatada", UtilData.formataData(new Date()));
		response.sendRedirect("operacoesBancarias.jsp");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		if(conta == null) {
			conta = new Conta();
		}
		
		if(contaService == null) {
			contaService = new ContaService();
		}
		
		if(transacaoService == null) {
			transacaoService = new TransacaoService();
		}
	}
	
	private void abrirConta() {
		
		try {
			contaService.salvar(conta);
			this.exibirMensagem("Ação Realizada com sucesso!");
		} catch (CamposObrigatoriosException e) {
			this.exibirMensagem("Preencha os dados obrigatorios");
		}
	}

}
