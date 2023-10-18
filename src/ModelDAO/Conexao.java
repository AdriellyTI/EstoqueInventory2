package ModelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	
	public static Connection conn;
			
	public  Connection getConnection() {
			
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/EstoqueM", "root", "asds2006");
		    
		} catch (ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		}
		return conn;
		
		

	
}

}

