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

    CadastroAdm administrador1= new CadastroAdm();

	
	public void CadastrarUsuarioAdm(String nome,String userName,String dataNasc,String telefone,String email,String senha,FileInputStream fis,int tamanho ) throws SQLException {
		

          CadastroAdm administrador= new CadastroAdm(nome,userName,dataNasc,telefone,email,senha);
          
          Connection conexao =new Conexao().getConnection();
          CadastroUsuariosDAO admDao= new CadastroUsuariosDAO(conexao);
          
          admDao.insertAdm(administrador, fis, tamanho);
	}

	
	public void CadastroFunc(String nome,String userName,String dataNasc,String telefone,String email,String senha,FileInputStream fis, int tamanho) {
		
		
		 CadastroFuncionario funcionario= new CadastroFuncionario(nome,userName,dataNasc,telefone,email,senha);
         try {
             Connection conexao =new Conexao().getConnection();
             CadastroUsuariosDAO funcio= new CadastroUsuariosDAO(conexao);
             
             funcio.insertFuncionario(funcionario, fis, tamanho);
             
             }catch (SQLException ex) {
             	Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE,null,ex);
				}
	}


	public void mostrarDados(JLabel lblFotoUser,JLabel lblNomeUserRet,JLabel lblNomeCompletoRet,JLabel lblEmailUserRet,JLabel lblIdadeUserRet) {
		administrador1.MostrarDadosUser(lblFotoUser,lblNomeUserRet,lblNomeCompletoRet,lblEmailUserRet,lblIdadeUserRet);
	}
	
	
}
