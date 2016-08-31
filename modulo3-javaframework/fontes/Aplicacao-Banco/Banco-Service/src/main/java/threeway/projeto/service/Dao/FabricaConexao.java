package threeway.projeto.service.Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao implements Serializable{
	
	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 9032716764106176071L;
	
	static String url = "jdbc:postgresql://localhost:5432/threeway";
	static String usuario = "postgres";
	static String senha = "123456";
	
	public static Connection getConexao() throws SQLException {

		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url,usuario,senha);

		}catch(ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}

}
