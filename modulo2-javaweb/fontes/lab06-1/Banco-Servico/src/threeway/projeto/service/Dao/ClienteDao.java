package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

import threeway.projeto.modelo.Cliente;

public class ClienteDao implements Dao<Cliente> {
	
	Connection conexao;
	
	public ClienteDao () {
		
		try {
			conexao = FabricaConexao.getConexao();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com banco de dados" + e.getMessage());
		}
		
	}

	private Collection<Cliente> clientesMemoria = new ArrayList<Cliente>();

	@Override
	public Cliente obter(Serializable identificador) {

		Cliente cliente = null;
		//Estamos criando a string de SQL que irá recuperar os dados de um cliente.
		String sql = "SELECT * FROM cliente WHERE identificador = ?";
				
				try {
			
					PreparedStatement consulta = conexao.prepareStatement(sql);
					
					consulta.setLong(1, (Long) identificador);
					
					ResultSet resultado = consulta.executeQuery();
					
					if(resultado.next()){
						
						cliente = new Cliente();
						
						cliente.setIdentificador(resultado.getLong("identificador"));

						cliente.setEndereco(resultado.getString("endereco"));

						cliente.setNome(resultado.getString("nome"));

						cliente.setTelefone(resultado.getString("telefone"));

						cliente.setCpf(resultado.getString("cpf"));

						cliente.setRg(resultado.getString("rg"));
					}
					
				} catch (SQLException e) {
					
					System.out.println("Erro ao realizar Select: " + e.getMessage());
				}
				
				return cliente;
	}

	@Override
	public void alterar(Cliente entidade) {

		for (Cliente cliente : clientesMemoria) {

			if (entidade.equals(cliente)) {

				clientesMemoria.remove(cliente);

				clientesMemoria.add(entidade);

				break;
			}

		}

	}

	@Override
	public void salvar(Cliente entidade) {
		
				//Estamos criando a string de SQL que irá salvar o cliente.
				StringBuffer sql = new StringBuffer();

				sql.append("INSERT INTO cliente");

				sql.append("(endereco, nome, telefone, cpf, rg) VALUES (?,?,?,?,?)");

				try {

					PreparedStatement consulta = conexao.prepareStatement(sql.toString());

					consulta.setString(1, entidade.getEndereco());

					consulta.setString(2, entidade.getNome());

					consulta.setString(3, entidade.getTelefone());

					consulta.setString(4, entidade.getCpf());

					consulta.setString(5, entidade.getRg());

					consulta.executeUpdate();

				} catch (SQLException e) {

					System.out.println("Erro ao realizar Insert: " + e.getMessage());
				}

	}

	@Override
	public void remover(Cliente entidade) {

			//Estamos criando a string de SQL que irá remover  o cliente.
			String sql = "DELETE FROM cliente WHERE identificador = ?";

			try {

				PreparedStatement consulta = conexao.prepareStatement(sql);

				consulta.setLong(1, entidade.getIdentificador());

				consulta.executeUpdate();

			} catch (SQLException e) {

				System.out.println("Erro ao realizar Delete: " + e.getMessage());
			}

	}

	@Override
	public Collection<Cliente> consultar(Cliente entidade) {

		return null;
	}

	@Override
	public Collection<Cliente> listar() {

		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		String sql = "SELECT * FROM cliente";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {

				Cliente cliente = new Cliente();

				cliente.setIdentificador(resultado.getLong("identificador"));

				cliente.setEndereco(resultado.getString("endereco"));

				cliente.setNome(resultado.getString("nome"));

				cliente.setTelefone(resultado.getString("telefone"));

				cliente.setCpf(resultado.getString("cpf"));

				cliente.setRg(resultado.getString("rg"));

				lista.add(cliente);

			}

		} catch (SQLException e) {
			
			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return lista;
	}

}
