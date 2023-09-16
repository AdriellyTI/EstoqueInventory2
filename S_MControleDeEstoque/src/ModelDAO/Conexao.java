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
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/EstoqueInnventory", "root", "asds2006");
		    
		} catch (ClassNotFoundException | SQLException e) {
		    e.printStackTrace();
		}
		return conn;
		
		
//		try {
//			
//			String url="jdbc:mysql://localhost:3306/EstoqueIInventory?user=root&password=asds2006";
//			conn = DriverManager.getConnection(url);
//			
//		} catch (SQLException erro) {
//             JOptionPane.showMessageDialog(null,"Conexao"+ erro.getMessage());
//		}
	}
	
}

	

