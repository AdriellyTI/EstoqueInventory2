package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.CadastroAdm;
import Model.CadastroFornecedor;
import Model.CadastroFuncionario;
import ModelDAO.CadastroUsuariosDAO;
import ModelDAO.Conexao;
import View.Administrador;
import View.Funcionario;
import View.ViewFornecedor;

public class ControllerCadastro {

	
	
	
	public void CadastrarUsuarioAdm(String nome,String userName,String dataNasc,String telefone,String email,String senha ) {
		

          CadastroAdm administrador= new CadastroAdm(nome,userName,dataNasc,telefone,email,senha);
          
          try {
          Connection conexao =new Conexao().getConnection();
          CadastroUsuariosDAO admDao= new CadastroUsuariosDAO(conexao);
          
          admDao.insertAdm(administrador);
          
          }catch (SQLException ex) {
          	Logger.getLogger(ControllerCadastro.class.getName()).log(Level.SEVERE,null,ex);
			}
	}

	public void CadastroForn(String nome,String userName,String cnpj, String telefoneComercial,String emailComercial,String telefoneRepresentante,String senha) {
		
		CadastroFornecedor fornecedor=new CadastroFornecedor(nome,userName,cnpj,telefoneComercial,emailComercial,telefoneRepresentante,senha);
        
        try {
        Connection conexao =new Conexao().getConnection();
        CadastroUsuariosDAO forn= new CadastroUsuariosDAO(conexao);
        
        forn.insertFornecedor(fornecedor);
        
        }catch (SQLException ex) {
       	 
        	Logger.getLogger(ControllerCadastro.class.getName()).log(Level.SEVERE,null,ex);
			}
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


}
