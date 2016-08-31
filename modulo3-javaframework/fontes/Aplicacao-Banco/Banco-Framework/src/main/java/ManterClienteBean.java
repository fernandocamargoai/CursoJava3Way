import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.service.ClienteService;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;

@Named
@SessionScoped
public class ManterClienteBean implements Serializable {
	
	private static final long serialVersionUID = -8735715935775329780L;
	
	@Inject
	private FacesContext facesContext;	
	
	@Inject
	private Cliente cliente;
	
	@Inject
	private ClienteService service;
	
	private Collection<Cliente> clientesCadastrados;
	
	@PostConstruct
	private void inicializaLista() {
		this.clientesCadastrados = this.getService().listarTodosClientes();
		this.cliente = new Cliente();
		
	}

	public void limpar() {
		this.cliente = new Cliente();
	}
	
	public void salvar() {
		
			try {
				if (this.cliente.getIdentificador() == null) {
					
					this.service.salvar(this.cliente);
					
				} else {
					this.service.atualizar(this.cliente);
				}
				
				this.inicializaLista();
				this.limpar();
				
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "CLiente salvo com sucesso"));
			} catch (CamposObrigatoriosException e) {
				
				facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", e.getMessage()));
			}
	}
	
	public void excluir() {

		this.service.excluir(this.cliente);
		
		
		
		this.limpar();
		this.inicializaLista();
	}
	
	public ClienteService getService() {
		return service;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Collection<Cliente> getClientesCadastrados() {
		return clientesCadastrados;
	}

	public void setClientesCadastrados(Collection<Cliente> clientesCadastrados) {
		this.clientesCadastrados = clientesCadastrados;
	}
	
	
	
}
