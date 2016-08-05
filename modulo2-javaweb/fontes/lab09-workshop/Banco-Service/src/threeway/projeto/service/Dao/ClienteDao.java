package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import threeway.projeto.modelo.Cliente;

public class ClienteDao implements Dao<Cliente> {
 
	Connection conexao;

	public ClienteDao(){

		try {
			
			conexao = FabricaConexao.getConexao();
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao conectar com banco de dados" + e.getMessage());
		}
	}

	@Override
	public Cliente obter(Serializable identificador) {

		Cliente cliente = null;
		
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

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE cliente SET ");

		sql.append("endereco = ?, ");

		sql.append("nome = ?, ");

		sql.append("telefone = ?, ");

		sql.append("cpf = ?, ");

		sql.append("rg = ? ");

		sql.append("WHERE identificador = ?");

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql.toString());

			consulta.setString(1, entidade.getEndereco());

			consulta.setString(2, entidade.getNome());

			consulta.setString(3, entidade.getTelefone());

			consulta.setString(4, entidade.getCpf());

			consulta.setString(5, entidade.getRg());

			consulta.setLong(6, entidade.getIdentificador());

			consulta.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Update: " + e.getMessage());
		}

	}

	@Override
	public void salvar(Cliente entidade) {

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

	public Cliente buscarClientePorCPF(String cpf) {

	Cliente cliente = null;
		
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		
		try {
	
			PreparedStatement consulta = conexao.prepareStatement(sql);
			
			consulta.setString(1, cpf);
			
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

}
