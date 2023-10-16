package Controller;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import Model.CadastroAdm;
import Model.CadastroFornecedor;
import Model.CadastroFuncionario;
import ModelDAO.CadastroUsuariosDAO;
import ModelDAO.Conexao;
import View.Administrador;
import View.Funcionario;
import View.ViewFornecedor;

public class ControllerCadastro {

	
	
	public void CadastrarUsuarioAdm(String nome,String userName,String dataNasc,String telefone,String email,String senha ) throws SQLException {
		

          CadastroAdm administrador= new CadastroAdm(nome,userName,dataNasc,telefone,email,senha);
          
          Connection conexao =new Conexao().getConnection();
          CadastroUsuariosDAO admDao= new CadastroUsuariosDAO(conexao);
          
          admDao.insertAdm( administrador, null, 0);
	}

	
	public void CadastroFunc(String nome,String userName,String dataNasc,String telefone,String email,String senha) {
		
		
		 CadastroFuncionario funcionario= new CadastroFuncionario(nome,userName,dataNasc,telefone,email,senha);
         try {
             Connection conexao =new Conexao().getConnection();
             CadastroUsuariosDAO funcio= new CadastroUsuariosDAO(conexao);
             
             funcio.insertFuncionario(funcionario);
             
             }catch (SQLException ex) {
             	Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE,null,ex);
				}
	}


	public void mostrarDados(String nome, String userName,String dataNasc,String telefone,String email) {
		
	}
	
	
}
