package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import threeway.projeto.modelo.Conta;
import threeway.projeto.modelo.enums.EnumTipoConta;

public class ContaDao implements Dao<Conta>, Serializable{

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -4834047194216078498L;
	
	private static AgenciaDao agenciaDao = new AgenciaDao();
	
	private static ClienteDao clienteDao = new ClienteDao();
	
	Connection conexao;

	public ContaDao() {

		try {

			conexao = FabricaConexao.getConexao();

		} catch (SQLException e) {

			System.out.println("Erro ao conectar com banco de dados" + e.getMessage());
		}
	}

	@Override
	public Conta obter(Serializable identificador) {

		Conta conta = null;

		String sql = "SELECT * FROM conta WHERE identificador = ?";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			consulta.setLong(1, (Long) identificador);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {

				conta = new Conta();

				conta.setIdentificador(resultado.getLong("identificador"));

				conta.setNumero(resultado.getInt("numero"));

				conta.setDataAbertura(resultado.getDate("dataAbertura"));

				conta.setSaldo(resultado.getDouble("saldo"));

				conta.setTipoConta(EnumTipoConta.valueOf(resultado.getString("tipoConta")));

				conta.setAgencia(agenciaDao.obter(resultado.getLong("id_agencia")));

				conta.setTitular(clienteDao.obter(resultado.getLong("id_titular")));
			}

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return conta;
	}

	@Override
	public void alterar(Conta entidade) {

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE conta SET ");

		sql.append("dataAbertura = ?, ");

		sql.append("numero = ?, ");

		sql.append("saldo = ?, ");

		sql.append("tipoConta = ?, ");

		sql.append("id_agencia = ?, ");

		sql.append("id_titular = ? ");

		sql.append("WHERE identificador = ?");

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql.toString());

			consulta.setDate(1, new java.sql.Date(entidade.getDataAbertura().getTime()));

			consulta.setInt(2, entidade.getNumero());

			consulta.setDouble(3, entidade.getSaldo());

			consulta.setString(4, entidade.getTipoConta().name());

			consulta.setLong(5, entidade.getAgencia().getIdentificador());

			consulta.setLong(6, entidade.getTitular().getIdentificador());

			consulta.setLong(7, entidade.getIdentificador());

			consulta.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Update: " + e.getMessage());
		}

	}

	@Override
	public void salvar(Conta entidade) {

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO conta");

		sql.append("(dataAbertura, numero, saldo, tipoConta, id_agencia, id_titular) VALUES (?,?,?,?,?,?)");

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql.toString());

			consulta.setDate(1, new java.sql.Date(entidade.getDataAbertura().getTime()));

			consulta.setInt(2, entidade.getNumero());

			consulta.setDouble(3, entidade.getSaldo());

			consulta.setString(4, entidade.getTipoConta().name());

			consulta.setLong(5, entidade.getAgencia().getIdentificador());

			consulta.setLong(6, entidade.getTitular().getIdentificador());

			consulta.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Insert: " + e.getMessage());
		}
	}

	@Override
	public void remover(Conta entidade) {

	}

	@Override
	public Collection<Conta> listar() {

		ArrayList<Conta> lista = new ArrayList<Conta>();

		String sql = "SELECT * FROM conta";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {

				Conta conta = new Conta();

				conta.setIdentificador(resultado.getLong("identificador"));

				conta.setNumero(resultado.getInt("numero"));

				conta.setDataAbertura(resultado.getDate("dataAbertura"));

				conta.setSaldo(resultado.getDouble("saldo"));

				conta.setTipoConta(EnumTipoConta.valueOf(resultado.getString("tipoConta")));

				conta.setAgencia(agenciaDao.obter(resultado.getLong("id_agencia")));

				conta.setTitular(clienteDao.obter(resultado.getLong("id_titular")));

				lista.add(conta);

			}

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return lista;
	}

}
