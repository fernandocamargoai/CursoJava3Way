package threeway.projeto.service;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Inject;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.modelo.enums.EnumStatus;
import threeway.projeto.service.DaoJPA.ClienteDaoImpl;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;

public class ClienteService implements Serializable{

	private static final long serialVersionUID = 6082782208927451337L;
	
	@Inject
	private ClienteDaoImpl dao;

	/**
	 * Método responsável por obter entidade cliente apartir de seu identificador
	 *
	 * @author Wilker Machado
	 *
	 * @param cliente
	 */
	public Cliente obter(Long identificador) {

		return this.getDao().obter(identificador);
	}
	
	/**
	 * Método responsável por Atualizar entidade cliente
	 *
	 * @author Wilker Machado
	 *
	 * @param cliente
	 * 
	 * @throws CamposObrigatoriosException
	 */
	public void atualizar(Cliente cliente) throws CamposObrigatoriosException {

		this.validarCamposObrigatorios(cliente);
		
		this.getDao().alterar(cliente);
		

	}

	/**
	 * Método responsável por excluir entidade cliente
	 *
	 * @author Wilker Machado
	 *
	 * @param cliente
	 */
	public void excluir(Cliente cliente) {
		
		cliente.setStatusCliente(EnumStatus.INATIVO);	
		
		this.getDao().alterar(cliente);

	}

	/**
	 * Método responsável por listar todos os clientes
	 *
	 * @author Wilker Machado
	 *
	 * @return ArrayList<Cliente>
	 */
	public ArrayList<Cliente> listarTodosClientes() {

		return new ArrayList<Cliente>(this.getDao().listar());
	}

	/**
	 * Método responsável por salvar a entiade cliente
	 *
	 * @author Wilker Machado
	 *
	 * @param cliente
	 * 
	 * @throws CamposObrigatoriosException
	 */
	public void salvar(Cliente cliente) throws CamposObrigatoriosException {

		this.validarCamposObrigatorios(cliente);

		this.getDao().salvar(cliente);

	}

	/**
	 * Método responsável por validar campos obrigatorios Nome e CPF de cliente
	 *
	 * @author Wilker Machado
	 *
	 * @param cliente
	 * 
	 * @throws CamposObrigatoriosException
	 */
	private void validarCamposObrigatorios(Cliente cliente) throws CamposObrigatoriosException {

		if (cliente == null || cliente.getNome().equals("") || cliente.getCpf().replace("-", "").replace(".", "").trim().equals("")) {

			throw new CamposObrigatoriosException();
		}
	}

	/**
	 * Método responsável por retornar a instancia de ClienteDao
	 *
	 * @author Wilker Machado
	 *
	 * @return
	 */
	public ClienteDaoImpl getDao() {

		return dao;
	}

	/**
	 * Método responsável por buscar cliente por cpf
	 *
	 * @author Wilker Machado
	 *
	 * @param cpf
	 * 
	 * @return Cliente
	 */
	public Cliente buscarClientePorCPF(String cpf) {

		return dao.buscarClientePorCPF(cpf);
	}

}
