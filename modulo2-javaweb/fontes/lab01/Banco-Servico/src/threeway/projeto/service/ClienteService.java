package threeway.projeto.service;

import java.util.ArrayList;

import threeway.projeto.modelo.Cliente;
import threeway.projeto.service.Dao.ClienteDao;
import threeway.projeto.service.excecoes.CamposObrigatoriosException;

public class ClienteService {

	private ClienteDao dao = new ClienteDao();

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

		this.getDao().remover(cliente);

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
	public ClienteDao getDao() {

		return dao;
	}

}
