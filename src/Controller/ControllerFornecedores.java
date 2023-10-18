package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.CadastroFornecedor;
import Model.ModelProduto;
import ModelDAO.Conexao;
import ModelDAO.FornecedoresDAO;
import View.ViewContrlForn;

public class ControllerFornecedores {
	
Connection con;
       
       FornecedoresDAO obj= new FornecedoresDAO();

	public static  ViewContrlForn Forn;
	
       public void CadastroForn(String nome,String cnpj, String telefoneComercial,String emailComercial,String telefoneRepresentante,String produtoForn ) {
		
		CadastroFornecedor fornecedor=new CadastroFornecedor(nome,cnpj,telefoneComercial,emailComercial,telefoneRepresentante,produtoForn);
         
        try {
        Connection conexao =new Conexao().getConnection();
        FornecedoresDAO forn= new FornecedoresDAO(conexao);
        
        forn.insertFornecedor(fornecedor);
        
        }catch (SQLException ex) {
       	 
        	Logger.getLogger(ControllerCadastro.class.getName()).log(Level.SEVERE,null,ex);
			}

		 
	}
       public void preencheForn(JTable tabela) {
    	   
    	List<CadastroFornecedor> lista=  obj.preencheForn();
    	   
   		DefaultTableModel modelo= (DefaultTableModel) tabela.getModel();
   		if (modelo.getRowCount()>0) {
   			modelo.setRowCount(0);
   		}
   		
   		for(CadastroFornecedor p: lista) {
   			
   			Object [] obj= new Object[7];
   			obj[0]=p.getIdFornecedor();
   			obj[1]= p.getNome();
   			obj[2]=p.getCnpj();
   			obj[3]=p.getTelefoneComercial();
   			obj[4]=p.getEmailComercial();
   			obj[5]=p.getTelefoneRepresentante();
   			obj[6]=p.getProdutoForn();
   			
   			
   			modelo.addRow(obj);
   		}
   	
       }
	
	
	
}
