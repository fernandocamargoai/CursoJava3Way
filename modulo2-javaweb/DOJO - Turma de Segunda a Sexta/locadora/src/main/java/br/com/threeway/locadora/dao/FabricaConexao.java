package br.com.threeway.locadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private static final String URL = "jdbc:mysql://localhost/Locadora2";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConexao() throws SQLException{

		try {

			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}


}
