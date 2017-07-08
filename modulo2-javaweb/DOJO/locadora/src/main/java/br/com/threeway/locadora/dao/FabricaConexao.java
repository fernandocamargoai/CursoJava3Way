package br.com.threeway.locadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private static final String URL = "jdbc:mysql://localhost/Locadora";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException|ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}


}
