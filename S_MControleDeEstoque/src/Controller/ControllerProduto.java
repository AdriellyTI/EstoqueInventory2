package Controller;
import java.sql.Connection;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.ModelFornecimento;
import Model.ModelProduto;
import ModelDAO.Conexao;
import ModelDAO.ProdutoDAO;
import View.ViewCompraAdm;


public class ControllerProduto {
	
	Connection con;
	
	ProdutoDAO Vproduto= new ProdutoDAO(null);
	 ModelProduto produto= new ModelProduto();
		
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

	
//      public void MostrarDadosProdutos(JTextField txtId,JTextField txtNome,JTextField txtPreco,JTextField txtNomeFornecedor,JTextField txtQuantEsto,JTextField txtDescricao)  {
//    	  Vproduto.BuscarProduto(txtId);
//    	  txtNome.setText(produto.getNome());
//    	 // txtPreco=Integer.parseInt(produto.getPreco());
//    	  txtNomeFornecedor.setText(produto.getNomeForn());
//    	  txtDescricao.setText(produto.getDescrição());
//      }
//      public void reporProduto(String dataFornec,int quantidade,String idProduto) {
//    	  
//    	  ModelFornecimento frn= new ModelFornecimento(dataFornec,quantidade,idProduto);
//    	  
// 		 Connection conexao =new Conexao().getConnection();
// 		 ProdutoDAO pdt= new ProdutoDAO(conexao);
// 		 
// 		// pdt.insertfornecimento(frn);
//    	  
//      }
	}
	



	
