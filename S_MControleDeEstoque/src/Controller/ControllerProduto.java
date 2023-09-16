package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelProduto;
import ModelDAO.CadastroUsuariosDAO;
import ModelDAO.Conexao;
import ModelDAO.ProdutoDAO;
import View.Funcionario;


public class ControllerProduto {
	
	Connection con;
	
//	public ControllerProduto(Connection connection) {
//		this.con = connection;
//	}
	
	public ControllerProduto() {
		
	}
	
	
	public void CadastrarProduto(int id ,String nome,double preco,int quantidade,int idForn,String descricao ) {
		
		ModelProduto produto= new ModelProduto(id,nome,preco,quantidade,idForn,descricao);
		
		 Connection conexao =new Conexao().getConnection();
		 
		 ProdutoDAO pdt= new ProdutoDAO(conexao);
		 
		 pdt.insertProduto(produto);
	}
	
	
public void preencheTable(JTable tabela) {
	
	tabela.setModel(new DefaultTableModel(
			   new Object[][] {		
				   
			   },
				new String [] {
						"Id","Nome","Preço","Quantidade","Nome do Fornecedor","Descrição"
				}
					
		  ));
			tabela.getColumnModel().getColumn(0).setPreferredWidth(76);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
			tabela.getColumnModel().getColumn(3).setPreferredWidth(199);
			tabela.getColumnModel().getColumn(4).setPreferredWidth(280);
			tabela.getColumnModel().getColumn(5).setPreferredWidth(360);
			
		ProdutoDAO Vproduto= new ProdutoDAO();
		List<ModelProduto> lista=  Vproduto.VerProdutos();
		DefaultTableModel modelo= (DefaultTableModel) tabela.getModel();
		if (modelo.getRowCount()>0) {
			modelo.setRowCount(0);
		}
		
		for(ModelProduto p: lista) {
			
			Object [] obj= new Object[6];
			obj[0]= p.getId();
			obj[1]= p.getNome();
			obj[2]=p.getPreco();
			obj[3]=p.getQuantidade();
			obj[4]=p.getIdForn();
			obj[5]=p.getDescrição();
			
			modelo.addRow(obj);
		}
	}
	
}