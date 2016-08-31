package threeway.projeto.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
import threeway.projeto.service.excecoes.ContaNaoExisteException;
import threeway.projeto.service.excecoes.SaldoInsuficienteException;

/**
 * Servlet implementation class OperacoesBancarias
 */
@WebServlet("/OperacoesBancarias")
public class OperacoesBancarias extends AppController {
	private static final long serialVersionUID = 1L;
       
	private Conta conta;
	
	private ContaService contaService;
	
	private TransacaoService transacaoService;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		if (conta == null){
			
			conta = new Conta();
		}
		
		if (contaService == null){
				
			contaService = new ContaService();
		}
		
		if (transacaoService == null){
			
			transacaoService = new TransacaoService();
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		Cliente clienteSession = (Cliente) request.getSession().getAttribute("cliente");
		
		Conta contaSession = (Conta) request.getSession().getAttribute("conta");	
		
		if (contaSession == null){
		
			//Recupera a conta que foi criada pelo usuario vinculado a sessão e lança o objeto conta na sessão para ser recuperada
			//e montar os dados na pagina
			request.getSession().setAttribute("conta", contaService.buscaContaPorCliente(clienteSession));		
		}


		Double valor = null;
		
		String action = request.getParameter("action");
		
		if ("abrirConta".equals(action)){
			
			conta.setDataAbertura(new Date());
		
			conta.setSaldo(Double.valueOf(request.getParameter("saldoInicial")));
		
			conta.setNumero(Integer.valueOf(request.getParameter("numero")));
			
			conta.setTitular(clienteSession);
			
			conta.setAgencia((Agencia) request.getSession().getAttribute("agencia"));
			
			conta.setTipoConta(EnumTipoConta.CONTA_PESSOAL);
		
			abrirConta();
			
			request.getSession().setAttribute("conta", contaService.buscaContaPorCliente(clienteSession));	
	
		}else 
			if ("saque".equals(action)){		
				
				valor =  Double.valueOf(request.getParameter("valor"));
				
				saque(contaSession,valor);
			
		}else 
			if("deposito".equals(action)){				
				
				valor =  Double.valueOf(request.getParameter("valor"));
				
				deposito(contaSession,valor);
		}else
			if ("transferencia".equals(action)){
				
				Integer numeroConta = Integer.valueOf(request.getParameter("numContaDestino"));
				
				valor =  Double.valueOf(request.getParameter("valor"));
				
				transferencia(contaSession, valor, numeroConta);
			}
		
		//Campo de data formatada no padrao dd/m/yyyy HH:mm, campo será exibido no modal de criar conta
		request.getSession().setAttribute("dataFormatada", UtilData.formataData(new Date()));		
		
		if (contaSession != null){
			request.getSession().setAttribute("transacoes", transacaoService.listarTransacoesPorConta(contaSession.getIdentificador()));
		}else{
			request.getSession().setAttribute("transacoes", null);
		}
		
		response.sendRedirect("operacoesBancarias.jsp");
	}

	
	private void abrirConta(){
		
		try {
			
			contaService.salvar(conta);
			
			this.exibirMensagem("Ação Realizada com sucesso!");
			
		} catch (CamposObrigatoriosException e) {
			
			this.exibirMensagem("Preencha os dados obrigatorios");
		}
	}
	
	
	private void saque(Conta conta, Double valor){
		
		try {
			
			contaService.sacar(conta, valor);
			
			this.exibirMensagem("Operação de saque realizada com sucesso!");
			
		} catch (SaldoInsuficienteException e) {
			
			this.exibirMensagem("Saldo insuficiente!");
		}
	}
	
	private void deposito(Conta conta, Double valor){
		
		contaService.depositar(conta, valor);
		
		this.exibirMensagem("Operação de deposito realizada com sucesso!");
	}
	
	private void transferencia(Conta contaSaque, Double valor, Integer numeroConta){
		
		try {
			
			Conta contaDestino = contaService.buscaContaPorNumero(numeroConta);
			
			contaService.transferir(contaSaque, valor, contaDestino);
			
			this.exibirMensagem("Operação de transferencia realizada com sucesso!");
		
		} catch (SaldoInsuficienteException e) {
			
			this.exibirMensagem("Saldo insuficiente!");
			
		} catch (ContaNaoExisteException e) {
			
			this.exibirMensagem("Conta não existe!");
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
