package br.com.threeway.locadora.dao;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao {

	public Filme pegueFilme(Long id){

		try(Connection conexao = FabricaConexao.getConexao();
			PreparedStatement stmt = conexao.prepareStatement("" +
					"SELECT * FROM filmes WHERE id =?")) {

			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				Filme filme = new Filme();
				filme.setId(rs.getLong("id"));
				filme.setNome(rs.getString("nome"));
				filme.setTipo(TipoFilme.valueOf(rs.getString("tipo")));
				return filme;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public List<Filme> listeFilmes(){
		List<Filme> lista = new ArrayList<>();
		try(Connection conexao = FabricaConexao.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(
					"SELECT * FROM filmes")) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()){
				Filme filme = new Filme();
				filme.setId(rs.getLong("id"));
				filme.setNome(rs.getString("nome"));
				filme.setTipo(TipoFilme.valueOf(rs.getString("tipo")));
				lista.add(filme);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}


	public void insira(Filme filme){
		try(Connection conexao = FabricaConexao.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(
					"INSERT INTO filmes (nome, tipo) VALUES (?, ?)")) {
			stmt.setString(1, filme.getNome());
			stmt.setString(2, String.valueOf(filme.getTipo()));

			Integer sucesso = stmt.executeUpdate();
			if(sucesso > 0){
				System.out.println("ok");
			}else{
				System.out.println("Problema");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualize(Filme filme){
		try(Connection conexao = FabricaConexao.getConexao();
			PreparedStatement stmt = conexao.prepareStatement(
					"UPDATE filmes SET nome=?, tipo=? WHERE id=?")) {

			stmt.setString(1, filme.getNome());
			stmt.setString(2, String.valueOf((filme.getTipo())));
			stmt.setLong(3,filme.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Long id){
		try (Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(
				"DELETE FROM filmes WHERE id=?")){

			stmt.setLong(1,id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
