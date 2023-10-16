package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.ModelFornecimento;
import Model.ModelProduto;
import View.ViewCompraAdm;

public class ProdutoDAO {

	 Connection conn;
	 
	 PreparedStatement stm ;
	 ResultSet rs;
	 
	 public ProdutoDAO(Connection conn) {
		this.conn=conn;
	}
	
	
	
	public void insertProduto(ModelProduto produt)  {
		
		
		String url ="INSERT INTO produtos (nome,preco,quantidade,nome_fornecedor,descricao) VALUES('"+produt.getNome()+"','"+ produt.getPreco()+"','"+ produt.getQuantidade()+"','"+ produt.getNomeForn()+"','"+produt.getDescricao()+"')";
		
		try  {
	       conn = new Conexao().getConnection();
           stm = conn.prepareStatement(url);

			stm.execute();
			
			//conn.close();

		
		}catch (Exception e) {
			 e.printStackTrace();
	}
	}
	
	 public List<ModelProduto> VerProdutos(){
		 
		 List <ModelProduto> listaAcesso = new ArrayList<ModelProduto>();
		 
		 String url = "SELECT *FROM produtos";
		 
			try {
				
                 conn = new Conexao().getConnection();
	             stm = conn.prepareStatement(url);
			      rs = stm.executeQuery();
			     
			 while(rs.next()) {
				 
				 ModelProduto p= new ModelProduto();
					
			     p.setId(rs.getInt("id"));
				 p.setNome(rs.getString("nome"));
				 p.setPreco(rs.getDouble("preco"));
				 p.setQuantidade(rs.getInt("quantidade"));
				 p.setNomeForn(rs.getString("nome_fornecedor"));
				 p.setDescricao(rs.getString("descricao"));
				 
				 listaAcesso.add(p);
			 }
			 
			 } catch (Exception e) {
				    e.printStackTrace(); 
			 }
			 return listaAcesso;

	 }
		
	 public List<ModelProduto> pesquisarProdutos(String desc){
		 
		 List <ModelProduto> listaAcesso = new ArrayList<ModelProduto>();
		 
		 String url = "SELECT id, nome, preco, quantidade,nome_fornecedor,descricao FROM produtos WHERE nome LIKE ?";
		 
			try  {
		          conn = new Conexao().getConnection();
		          stm = conn.prepareStatement(url);
			     
			      rs = stm.executeQuery();
				  stm.setString(1, "%"+desc+"%");

			 while(rs.next()) {
				 ModelProduto p2= new ModelProduto();
					
			     p2.setId(rs.getInt("id"));
				 p2.setNome(rs.getString("nome"));
				 p2.setPreco(rs.getDouble("preco"));
				 p2.setQuantidade(rs.getInt("quantidade"));
				 p2.setNomeForn(rs.getString("nome_fornecedor"));
				 p2.setDescricao(rs.getString("descricao"));
				 
				 listaAcesso.add(p2);
			 }
			 }catch (Exception e) {
				 JOptionPane.showInternalMessageDialog(null, e);
				}

			 return listaAcesso;
	 }
}
//   public void insertfornecimento(ModelFornecimento fnc) {
//		 
//	   String url="INSERT INTO Fornecimento(data,quantidade,idProduto) VALUES ('"+fnc.getDataFornec()+"','"+fnc.getQuantide()+"','"+fnc.getIdProduto()+"')";
//	   
//	   try {
//					 
//		    Connection conn = new Conexao().getConnection();
//		     PreparedStatement stm = conn.prepareStatement(url);
//			
//			stm.execute();
//			
//			conn.close();
//
//		
//		}catch (Exception e) {
//			 e.printStackTrace(); 
//		}
//	   
//	}
//	

//	public void BuscarProduto(JTextField txtId) {
//		
//		 String url = "SELECT *FROM produtos WHERE id= ?";
//     try { 
//    	 conn=new Conexao().getConnection();
//    	 stm = conn.prepareStatement(url);
//    	 stm.setString(1,txtId.getText());
//    	 rs=stm.executeQuery();
//    	 
//  		if (rs.next()) {
//  			
//			 p.setNome(rs.getString("nome"));
//			 p.setPreco(rs.getDouble("preco"));
//			 p.setQuantidade(rs.getInt("quantidade"));
//			 p.setNomeForn(rs.getString("nome_fornecedor"));
//			 p.setDescrição(rs.getString("descricao"));
//			 
//  		}else {
//			 JOptionPane.showInternalMessageDialog(null, "Produto não cadastrado");
//             conn.close();
//  		}
//    	  
//    	  
//     }catch (Exception e) {
//     }
//		// TODO: handle exception
//	}
   

