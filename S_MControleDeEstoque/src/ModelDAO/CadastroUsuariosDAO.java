package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.CadastroAdm;
import Model.CadastroFornecedor;
import Model.CadastroFuncionario;
import Model.VO_USUARIO;

public class CadastroUsuariosDAO {

	 Connection connection;
	
	public CadastroUsuariosDAO(Connection connection) {
		this.connection = connection;
	}
	
	public CadastroUsuariosDAO() {
		
	}
	 public void insertFuncionario(CadastroFuncionario usuarioFunc) throws SQLException {
	    	
	     
			
			String url="INSERT INTO Funcionario(nomeCompleto,userName,dataNasc,tele,email,senha) VALUES('"+usuarioFunc.getNome()+"','"+usuarioFunc.getUserName()+"','"+usuarioFunc.getDataNasc()+"','"+usuarioFunc.getTelefone()+"','"+usuarioFunc.getEmail()+"','"+usuarioFunc.getSenha() +"')";
			
			PreparedStatement statement = connection.prepareStatement(url);
			statement.execute();
			
			connection.close();
	 }
	 
	 public void insertAdm(CadastroAdm usuarioAdm) throws SQLException {
		 
		 
		 String url="INSERT INTO Administrador(nomeCompleto,userName,dataNasc,tele,email,senha) VALUES('"+usuarioAdm.getNome()+"','"+usuarioAdm.getUserName()+"','"+usuarioAdm.getDataNasc()+"','"+usuarioAdm.getTelefone()+"','"+usuarioAdm.getEmail()+"','"+usuarioAdm.getSenha() +"')";
		 
		 PreparedStatement statement = connection.prepareStatement(url);
		 
		 statement.execute();
		 connection.close();
		 
	 }
	 
 public void insertFornecedor(CadastroFornecedor usuarioAdm) throws SQLException {
		 
		 
		 String url="INSERT INTO Fornecedorr(nomeEmpresa,userName,cnpj,teleComercial,emailComercial,teleRepre,senha) VALUES('"+usuarioAdm.getNome()+"','"+usuarioAdm.getUserName()+"','"+usuarioAdm.getCnpj()+"','"+usuarioAdm.getTelefoneComercial()+"','"+usuarioAdm.getEmailComercial()+"','"+usuarioAdm.getSenha() +"')";
		 
		 PreparedStatement statement = connection.prepareStatement(url);
		 
		 statement.execute();
		 connection.close();
		 
	 }
	 
	 public  ResultSet AutentucaçãoUsuario(VO_USUARIO usuario) {
		 connection= new Conexao().getConnection();
		 
		 try {
			 
			 String sql="SELECT * FROM Funcionario WHERE userName=? and senha=? ";
			 
			 PreparedStatement pstm= connection.prepareStatement(sql);
			 
			 pstm.setString(1, usuario.getUsername());
			 pstm.setString(2, usuario.getSenha());

			 ResultSet rs= pstm.executeQuery();
			 
			 return rs;
			 
		 }catch (SQLException erro) {
			 JOptionPane.showMessageDialog(null,"CadastroUsuariosDAO: "+erro);
			// TODO: handle exception
		}
		return null;
	 }


	
	
}
//    
//}
//    
//

