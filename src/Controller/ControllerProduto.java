package Controller;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.ModelFornecimento;
import Model.ModelProduto;
import ModelDAO.Conexao;
import ModelDAO.ProdutoDAO;


public class ControllerProduto {
	
	Connection con;
	
	ProdutoDAO Vproduto= new ProdutoDAO(null);
	 ModelProduto produto= new ModelProduto();
		
	public void CadastrarProduto(String nome,double preco,int quantidade,String nomeForn,String descricao,double precoVenda,FileInputStream fis,int tamanho) {
		
		 ModelProduto produto= new ModelProduto(nome,preco,precoVenda,quantidade,nomeForn,descricao);
		 
		 Connection conexao =new Conexao().getConnection();
		 ProdutoDAO pdt= new ProdutoDAO(conexao);
		 
		 try {
			pdt.insertProduto(produto, fis, tamanho);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
			obj[5]=p.getDescricao();
			
			modelo.addRow(obj);
		}
}
      public void pesquisarProduto(JTable tabela,String desc) {
    	  
    	  
  		   DefaultTableModel modelo= (DefaultTableModel) tabela.getModel();
  		if (modelo.getRowCount()>0) {
  			modelo.setRowCount(0);
  	

  		ProdutoDAO pr= new ProdutoDAO(con);
  		
  		for(ModelProduto p: pr.pesquisarProdutos(desc)) {
  			
  			Object [] obj= new Object[6];
  			obj[0]=p.getId();
  			obj[1]= p.getNome();
  			obj[2]=p.getPreco();
  			obj[3]=p.getQuantidade();
  			obj[4]=p.getNomeForn();
  			obj[5]=p.getDescricao();
  			
  			modelo.addRow(obj);
  		}
  		}
      }

	
      public void MostrarDadosProdutos(JTextField txtId,JTextField txtNome,JTextField txtPreco,JTextField txtNomeFornecedor,JTextField txtQuantEsto,JTextField txtDescricao,JLabel lblFoto)  {
    	Vproduto.BuscarProduto(txtId, txtNome, txtNomeFornecedor, txtQuantEsto, txtPreco, txtDescricao,lblFoto); 
      }
      
      
       public void registrarFornecimento(String dataFornec,int quantidadeForn,int quantidadeEstoque,String nomeProduto,int idProduto,String nomeFornecedor, Double precoProduto) {

    	   ModelFornecimento mdFor= new ModelFornecimento(dataFornec,quantidadeForn,quantidadeEstoque,nomeProduto,idProduto,nomeFornecedor,precoProduto);
  		 
    	   Connection conexao =new Conexao().getConnection();
  		    ProdutoDAO pdt= new ProdutoDAO(conexao);
  		 
  		 pdt.insertfornecimento(mdFor);
       }
	}
	



	
