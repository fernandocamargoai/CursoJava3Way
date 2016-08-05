package threeway.projeto.service.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	public static String url = "jdbc:postgresql://localhost:5432/threewayweb";
	public static String usuario = "postgres";
	public static String senha = "123456";
	
	public static Connection getConexao() throws SQLException {

		try{
			
/*			Class.forName("org.postgresql.Driver");
			
			return DriverManager.getConnection(url,usuario,senha); */
			
			
            Class.forName("org.postgresql.Driver");  
  
            Connection con;  
  
            con = DriverManager.getConnection(url, usuario, senha); 
            
            return con;

		}catch(ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}

}
