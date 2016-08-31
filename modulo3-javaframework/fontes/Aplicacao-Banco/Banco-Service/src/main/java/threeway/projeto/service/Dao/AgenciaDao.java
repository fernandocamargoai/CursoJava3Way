package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import threeway.projeto.modelo.Agencia;

public class AgenciaDao implements Dao<Agencia>, Serializable{

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -4866025430463256931L;
	
	private static BancoDao bancodao = new BancoDao();
	
	Connection conexao;

	public AgenciaDao(){

		try {
			
			conexao = FabricaConexao.getConexao();
			
		} catch (SQLException e) {
			
			System.out.println("Erro ao conectar com banco de dados" + e.getMessage());
		}
	}
	
	@Override
	public Agencia obter(Serializable identificador) {
		
		Agencia agencia = null;

		String sql = "SELECT * FROM agencia WHERE identificador = ?";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			consulta.setLong(1, (Long) identificador);

			ResultSet resultado = consulta.executeQuery();

			if (resultado.next()) {

				agencia = new Agencia();

				agencia.setIdentificador(resultado.getLong("identificador"));

				agencia.setBanco(bancodao.obter(resultado.getLong("id_banco")));

				agencia.setNome(resultado.getString("nome"));

			}

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return agencia;
	}

	@Override
	public void alterar(Agencia entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvar(Agencia entidade) {
		
		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO agencia");

		sql.append("(nome, id_banco) VALUES (?,?)");

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql.toString());

			consulta.setString(1, entidade.getNome());

			consulta.setLong(2, (entidade.getBanco().getIdentificador()));

			consulta.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Insert: " + e.getMessage());
		}
		
	}

	@Override
	public void remover(Agencia entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Collection<Agencia> listar() {
		
		ArrayList<Agencia> lista = new ArrayList<Agencia>();

		String sql = "SELECT * FROM agencia";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {

				Agencia agencia = new Agencia();

				agencia.setIdentificador(resultado.getLong("identificador"));

				agencia.setBanco(bancodao.obter(resultado.getLong("id_banco")));

				agencia.setNome(resultado.getString("nome"));

				lista.add(agencia);

			}

		} catch (SQLException e) {
			
			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return lista;

	}

}
