package ModelDAO;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Model.CadastroAdm;
import Model.CadastroFornecedor;
import Model.CadastroFuncionario;
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
	 public void insertFuncionario(CadastroFuncionario usuarioFunc,FileInputStream fis,int tamanho) throws SQLException {
	    	
	  
		  String sql = "INSERT INTO Administrador(nomeCompleto, userName, dataNasc, tele, email, senha, foto) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    
		    try (PreparedStatement statement = connection.prepareStatement(sql)) {
		    	
		        statement.setString(1, usuarioFunc.getNome());
		        statement.setString(2, usuarioFunc.getUserName());
		        
		        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		        Date dataNasc = new Date(sdf.parse(usuarioFunc.getDataNasc()).getTime());
		        statement.setDate(3, dataNasc);
		        
		        statement.setString(4, usuarioFunc.getTelefone());
		        statement.setString(5, usuarioFunc.getEmail());
		        statement.setString(6, usuarioFunc.getSenha());
		       statement.setBinaryStream(7,fis, tamanho);
		     

		        int confirma = statement.executeUpdate();

		        if (confirma == 1) {
		            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
		        } else {
		            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o usuário");
		        }
		    } catch (SQLException | ParseException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuário: " + e.getMessage());
		    }
		}

	
	 public void insertAdm(CadastroAdm usuarioAdm,FileInputStream fis,int tamanho) {
		    String sql = "INSERT INTO Administrador(nomeCompleto, userName, dataNasc, tele, email, senha, foto) VALUES (?, ?, ?, ?, ?, ?, ?)";
		    
		    try (PreparedStatement statement = connection.prepareStatement(sql)) {
		    	
		        statement.setString(1, usuarioAdm.getNome());
		        statement.setString(2, usuarioAdm.getUserName());
		        
		        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		        Date dataNasc = new Date(sdf.parse(usuarioAdm.getDataNasc()).getTime());
		        statement.setDate(3, dataNasc);
		        
		        statement.setString(4, usuarioAdm.getTelefone());
		        statement.setString(5, usuarioAdm.getEmail());
		        statement.setString(6, usuarioAdm.getSenha());
		       statement.setBinaryStream(7,fis, tamanho);
		     

		        int confirma = statement.executeUpdate();

		        if (confirma == 1) {
		            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
		        } else {
		            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o usuário");
		        }
		    } catch (SQLException | ParseException e) {
		        e.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuário: " + e.getMessage());
		    }
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
		}
		return null;
	 }
	 
	 public  ResultSet AutentucaçãoUsuarioA(VO_USUARIO usuario2) {
		 connection= new Conexao().getConnection();
		 try { 
			 String sql="SELECT * FROM Administrador WHERE userName=? and senha=? ";
			 
			 PreparedStatement pstm= connection.prepareStatement(sql);
			 
			 pstm.setString(1, usuario2.getUsername());
			 pstm.setString(2, usuario2.getSenha());

			 ResultSet rs= pstm.executeQuery();
			 
			 return rs;
			 
		 }catch (SQLException erro) {
			 JOptionPane.showMessageDialog(null,"CadastroUsuariosDAO: "+erro);
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

