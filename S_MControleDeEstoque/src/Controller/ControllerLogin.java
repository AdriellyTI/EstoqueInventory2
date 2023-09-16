package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.VO_USUARIO;
import ModelDAO.CadastroUsuariosDAO;
import View.ViewMenuFuncionario;

public class ControllerLogin {

	public void Autenticar(String username,String senha) {
		
		try {
		  VO_USUARIO usuario= new VO_USUARIO(); 
     	  usuario.setUsername(username);
		  usuario.setSenha(senha); 
		
		  CadastroUsuariosDAO usua= new  CadastroUsuariosDAO();
		  ResultSet usuarioDAO=usua.AutentucaçãoUsuario(usuario);
		  
		  if (usuarioDAO.next()) {
			  
		
			  new ViewMenuFuncionario();
			   
		} else {
              JOptionPane.showMessageDialog(null, "Nome de usuário ou senha incorreto");
		}
		}catch(SQLException erro){
			JOptionPane.showMessageDialog(null,"ControllerLogin: "+erro);
		}
	}
	
}
