package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import threeway.projeto.modelo.Transacao;
import threeway.projeto.modelo.enums.EnumTipoTransacao;

public class TransacaoDao implements Dao<Transacao> {

	Connection conexao;

	public TransacaoDao() {

		try {

			conexao = FabricaConexao.getConexao();

		} catch (SQLException e) {

			System.out.println("Erro ao conectar com banco de dados" + e.getMessage());
		}
	}

	@Override
	public Transacao obter(Serializable identificador) {

		return null;
	}

	@Override
	public void alterar(Transacao entidade) {

	}

	@Override
	public void salvar(Transacao entidade) {

		StringBuffer sql = new StringBuffer();

		sql.append("INSERT INTO transacao");

		sql.append("(data, valor, descricao, tipoTransacao, id_contaCredito, id_contaDebito) VALUES (?,?,?,?,?,?)");

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql.toString());

			consulta.setDate(1, new java.sql.Date(entidade.getData().getTime()));

			consulta.setDouble(2, entidade.getValor());

			consulta.setString(3, entidade.getDescricao());

			consulta.setString(4, entidade.getTipoTransacao().name());

			consulta.setLong(5, entidade.getContaCredito().getIdentificador());

			if (entidade.getContaDebito() != null) {
				
				consulta.setLong(6, entidade.getContaDebito().getIdentificador());
				
			}else{
				
				consulta.setObject(6, null);
			}

			consulta.executeUpdate();

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Insert: " + e.getMessage());
		}
	}

	@Override
	public void remover(Transacao entidade) {

	}

	@Override
	public Collection<Transacao> consultar(Transacao entidade) {

		return null;
	}

	@Override
	public Collection<Transacao> listar() {

		ArrayList<Transacao> lista = new ArrayList<Transacao>();

		String sql = "SELECT * FROM transacao";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {

				Transacao transacao = new Transacao();

				transacao.setIdentificador(resultado.getLong("identificador"));

				transacao.setData(resultado.getDate("data"));

				transacao.setValor(resultado.getDouble("valor"));

				transacao.setDescricao(resultado.getString("descricao"));

				transacao.setTipoTransacao(EnumTipoTransacao.valueOf(resultado.getString("tipoTransacao")));

				transacao.setContaCredito(new ContaDao().obter(resultado.getLong("id_contaCredito")));

				transacao.setContaDebito(new ContaDao().obter(resultado.getLong("id_contaDebito")));

				lista.add(transacao);

			}

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return lista;
	}

	/**
	 * Método responsável por listar as transações de determinada conta
	 * 
	 * @author Wilker Machado
	 * 
	 * @param identificador
	 * 
	 * @return Collection<Transacao>
	 */
	public Collection<Transacao> listarTransacoesPorConta(Long identificador) {

		ArrayList<Transacao> lista = new ArrayList<Transacao>();

		String sql = "SELECT * FROM transacao WHERE id_contaCredito = ? OR id_contaDebito = ?";

		try {

			PreparedStatement consulta = conexao.prepareStatement(sql);

			consulta.setLong(1, (Long) identificador);
			
			consulta.setLong(2, (Long) identificador);

			ResultSet resultado = consulta.executeQuery();

			while (resultado.next()) {

				Transacao transacao = new Transacao();

				transacao.setIdentificador(resultado.getLong("identificador"));

				transacao.setData(resultado.getDate("data"));

				transacao.setValor(resultado.getDouble("valor"));

				transacao.setDescricao(resultado.getString("descricao"));

				transacao.setTipoTransacao(EnumTipoTransacao.valueOf(resultado.getString("tipoTransacao")));

				transacao.setContaCredito(new ContaDao().obter(resultado.getLong("id_contaCredito")));

				transacao.setContaDebito(new ContaDao().obter(resultado.getLong("id_contaDebito")));

				lista.add(transacao);

			}

		} catch (SQLException e) {

			System.out.println("Erro ao realizar Select: " + e.getMessage());
		}

		return lista;
	}

}
