package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.VO_USUARIO;
import ModelDAO.CadastroUsuariosDAO;
import View.ViewMenuAdministrador;
import View.ViewMenuFuncionario;

public class ControllerLogin {

	private int n=0;
	public void Autenticar(String username,String senha) {
	
		if(username.length()!=n || senha.length()!=n) {
			
		try {
			
		  VO_USUARIO usuario= new VO_USUARIO(); 
		  
     	  usuario.setUsername(username);
		  usuario.setSenha(senha); 
		
		  CadastroUsuariosDAO usua= new  CadastroUsuariosDAO();
		  
		  ResultSet usuarioDAO=usua.AutentucaçãoUsuarioF(usuario);
		  
		  ResultSet usuarioDAOA=usua.AutentucaçãoUsuarioA(usuario);
		  
		  if (usuarioDAO.next()) {
			  new ViewMenuFuncionario();
			   
		} else  if (usuarioDAOA.next()) {
			
			new ViewMenuAdministrador();
		  }else {
              JOptionPane.showMessageDialog(null, "Usuário não identificado");
		  }
		}catch(SQLException erro){
			JOptionPane.showMessageDialog(null,"ControllerLogin: "+erro);
		}
		
		}else {
			JOptionPane.showMessageDialog(null,"Os campos não foram preenchidos");
		}
	}
}