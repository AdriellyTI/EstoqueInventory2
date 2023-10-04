package Controller;
import java.sql.Connection;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.ModelProduto;
import ModelDAO.Conexao;
import ModelDAO.ProdutoDAO;


public class ControllerProduto {
	
	Connection con;
	
	ProdutoDAO Vproduto= new ProdutoDAO();
	
	public ControllerProduto() {
		
	}
	
	public void CadastrarProduto(String nome,double preco,int quantidade,String nomeForn,String descricao ) {
		
		ModelProduto produto= new ModelProduto(nome,preco,quantidade,nomeForn,descricao);
		
		 Connection conexao =new Conexao().getConnection();
		 
		 ProdutoDAO pdt= new ProdutoDAO(conexao);
		 
		 pdt.insertProduto(produto);
	}
	
	
public void preencheTable(JTable tabela) {
			
		List<ModelProduto> lista=  Vproduto.VerProdutos();
		
		DefaultTableModel modelo= (DefaultTableModel) tabela.getModel();
		if (modelo.getRowCount()>0) {
			modelo.setRowCount(0);
		}
		
		for(ModelProduto p: lista) {
			
			Object [] obj= new Object[6];
			obj[0]=p.getId();
			obj[1]= p.getNome();
			obj[2]=p.getPreco();
			obj[3]=p.getQuantidade();
			obj[4]=p.getNomeForn();
			obj[5]=p.getDescrição();
			
			modelo.addRow(obj);
		}
	
		}
  
      public void pesquisarProduto(JTable tabela,String desc) {
    	  
    	  List<ModelProduto> lista=  Vproduto.VerProdutos();
  		   DefaultTableModel modelo= (DefaultTableModel) tabela.getModel();
  		if (modelo.getRowCount()>0) {
  			modelo.setRowCount(0);
  		}

  		ProdutoDAO pr= new ProdutoDAO();
  		
  		for(ModelProduto p: pr.pesquisarProdutos(desc)) {
  			
  			Object [] obj= new Object[6];
  			obj[0]=p.getId();
  			obj[1]= p.getNome();
  			obj[2]=p.getPreco();
  			obj[3]=p.getQuantidade();
  			obj[4]=p.getNomeForn();
  			obj[5]=p.getDescrição();
  			
  			modelo.addRow(obj);
  		}
  	
      }


	}

  
	
