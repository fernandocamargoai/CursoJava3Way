package br.com.threeway.locadora.dao;

import br.com.threeway.locadora.domain.Filme;
import br.com.threeway.locadora.domain.TipoFilme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {

	public void cadastro(Filme filme){
		try(Connection connection = FabricaConexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO Filmes(nome,tipo) VALUES(?,?)");
		){

			stmt.setString(1,filme.getNome());
			stmt.setString(2,filme.getTipo().name());
			int linhasModificadas =  stmt.executeUpdate();
			if (linhasModificadas > 0){
				try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {

					if (generatedKeys.next()) {
						filme.setId(generatedKeys.getLong(1));
					}
					else {
						throw new SQLException("Falha ao incluir o FILME.");
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Filme filme){
		try(Connection connection = FabricaConexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE Filmes SET nome = ?,tipo = ? WHERE id = ?");
		){

			stmt.setString(1,filme.getNome());
			stmt.setString(2,filme.getTipo().name());
			stmt.setLong(3,filme.getId());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Filme> findAll(){

		List<Filme> filmes = new ArrayList<>();

		try(Connection connection = FabricaConexao.getConnection();
		    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Filmes")){

			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				Filme filme = new Filme();
				filme.setId(rs.getLong("id"));
				filme.setNome(rs.getString("nome"));
				filme.setTipo(TipoFilme.valueOf(rs.getString("tipo")));

				filmes.add(filme);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmes;
	}

	public Filme find(long id){

		try(Connection connection = FabricaConexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Filmes WHERE id = ?")){

			stmt.setLong(1,id);
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

	public void delete(long id){

		try(Connection connection = FabricaConexao.getConnection();
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM Filmes WHERE id = ?")){

			stmt.setLong(1,id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
