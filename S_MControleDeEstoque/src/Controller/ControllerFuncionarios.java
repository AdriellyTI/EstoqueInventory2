package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.CadastroFuncionario;
import ModelDAO.CadastroUsuariosDAO;

public class ControllerFuncionarios {

     
	CadastroUsuariosDAO objC= new CadastroUsuariosDAO();
	
	public void VerFuncionariosAtivos(JTable tabela) { 
		
		List<CadastroFuncionario> lista=objC.VerFuncionariosAtivos();
				
   		DefaultTableModel modelo= (DefaultTableModel) tabela.getModel();
   		if (modelo.getRowCount()>0) {
   			modelo.setRowCount(0);
   		}
   		
   		for(CadastroFuncionario f: lista ) {
   			
   			Object [] obj= new Object[5];
   			
   			obj[0]=f.getIdFuncionario();
   			obj[1]=f.getNome();
   			obj[2]=f.getDataNasc();
   			obj[3]=f.getTelefone();
   			obj[4]=f.getEmail();
   			
   			modelo.addRow(obj);
   		}
   	
	}
	
	
}
