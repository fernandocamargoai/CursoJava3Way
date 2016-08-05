package threeway.projeto.lab01;

import java.sql.*;

import threeway.projeto.service.Dao.FabricaConexao;

public class TestaConexão {
	
	public static void main(String[] args) {
		Connection con;
		try {
			con = FabricaConexao.getConexao();
			if(con!=null)
				System.out.println("Conexao estabelecida!");

			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

