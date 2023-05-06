package br.com.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoDAO {

	public Connection conexaoBD() throws ClassNotFoundException{
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/igor";
			String usuario = "root";
			String senha = "Igordt2019!";
			con = DriverManager.getConnection(url,usuario,senha);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
