package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import threeway.projeto.modelo.Banco;

public class BancoDao implements Dao<Banco>, Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 311774354750607751L;
	
	Connection conexao;

	public BancoDao() {

		try {

			conexao = FabricaConexao.getConexao();

		} catch (SQLException e) {

			System.out.println("Erro ao conectar com banco de dados" + e.getMessage());
		}
	}

	@Override
	public Banco obter(Serializable identificador) {

		Banco Banco = null;

		String sql = "SELECT * FROM banco WHERE identificador = ?";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			consulta.setLong(1, (Long) identificador);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {

				Banco = new Banco();

				Banco.setIdentificador(resultado.getLong("identificador"));

				Banco.setNumero(resultado.getInt("numero"));

				Banco.setNome(resultado.getString("nome"));

			}

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return Banco;
	}

	@Override
	public void alterar(Banco entidade) {

		// TODO Auto-generated method stub

	}

	@Override
	public void salvar(Banco entidade) {

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO banco");

		sql.append("(numero, nome) VALUES (?,?)");

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql.toString());

			consulta.setInt(1, ( entidade.getNumero() ));

			consulta.setString(2, entidade.getNome());

			consulta.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Insert: " + e.getMessage());
		}

	}

	@Override
	public void remover(Banco entidade) {

		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Banco> listar() {

		ArrayList<Banco> lista = new ArrayList<Banco>();

		String sql = "SELECT * FROM banco";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {

				Banco banco = new Banco();

				banco.setIdentificador(resultado.getLong("identificador"));

				banco.setNumero(resultado.getInt("numero"));

				banco.setNome(resultado.getString("nome"));

				lista.add(banco);

			}

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return lista;

	}

}
