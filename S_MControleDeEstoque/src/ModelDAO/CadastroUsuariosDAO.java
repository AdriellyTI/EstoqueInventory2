package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.CadastroAdm;
import Model.CadastroFornecedor;
import Model.CadastroFuncionario;
import Model.ModelPagamentos;
import Model.VO_USUARIO;

public class CadastroUsuariosDAO {

	 Connection connection;
	 PreparedStatement statement;
	 ResultSet rs;
	
	public CadastroUsuariosDAO(Connection connection) {
		this.connection = connection;
	}
	
	public CadastroUsuariosDAO() {
		
	}
	 public void insertFuncionario(CadastroFuncionario usuarioFunc) throws SQLException {
	    	
	  
			String url="INSERT INTO Funcionario(nomeCompleto,userName,dataNasc,tele,email,senha) VALUES('"+usuarioFunc.getNome()+"','"+usuarioFunc.getUserName()+"','"+usuarioFunc.getDataNasc()+"','"+usuarioFunc.getTelefone()+"','"+usuarioFunc.getEmail()+"','"+usuarioFunc.getSenha() +"')";
			
			 statement = connection.prepareStatement(url);
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
		 
	 String url="INSERT INTO Fornecedoor(nomeEmpresa,cnpj,teleComercial,emailComercial,teleRepre,produtoForn) VALUES('"+usuarioAdm.getNome()+"','"+usuarioAdm.getCnpj()+"','"+usuarioAdm.getTelefoneComercial()+"','"+usuarioAdm.getEmailComercial()+"','"+usuarioAdm.getTelefoneRepresentante()+"','"+usuarioAdm.getProdutoForn()+"')";
		 
		 PreparedStatement statement = connection.prepareStatement(url);
		 
		 statement.execute();
		 connection.close();
		 
	 }
	 
	 public  ResultSet AutentucaçãoUsuarioF(VO_USUARIO usuario) {
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
	 
	 public  ResultSet AutentucaçãoUsuarioA(VO_USUARIO usuario) {
		 connection= new Conexao().getConnection();
		 
		 try {
			 
			 String sql="SELECT * FROM Administrador WHERE userName=? and senha=? ";
			 
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


public List<CadastroFuncionario> VerFuncionariosAtivos(){
		 
		 List <CadastroFuncionario> listaAcesso = new ArrayList<CadastroFuncionario>();
		 
		 String url = "SELECT idFuncionario,nomeCompleto,dataNasc,tele,email FROM Funcionario";
		 
			try {
				
	             Connection conn =new Conexao().getConnection();

	             statement= conn.prepareStatement(url);
				rs=statement.executeQuery();
		

			 while(rs.next()) {
				 CadastroFuncionario p= new CadastroFuncionario();
				
                 p.setIdFuncionario(rs.getInt("idFuncionario"));	
                 p.setNome(rs.getString("nomeCompleto"));
                 p.setDataNasc(rs.getString("dataNasc"));
                 p.setTelefone(rs.getString("tele"));
                 p.setEmail(rs.getString("email"));
                 
				 listaAcesso.add(p);
			 }
			 
			 }catch (Exception e) {
				 JOptionPane.showInternalMessageDialog(null, e);
				}
			 return listaAcesso;

	 }
	

	
}
//    
//}
//    
//

