package ModelDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.ModelFornecimento;
import Model.ModelProduto;

public class ProdutoDAO {

	 Connection conn;
	 
	 PreparedStatement stm ;
	 ResultSet rs;
	 
	 public ProdutoDAO(Connection conn) {
		this.conn=conn;
	}
	
	
	
	 public void insertProduto(ModelProduto produto, FileInputStream fis, int tamanho) throws SQLException {
		    String url = "INSERT INTO produtos(nome, preco, quantidade, nome_fornecedor, descricao, foto) VALUES (?, ?, ?, ?, ?, ?)";

		    try (PreparedStatement statement = conn.prepareStatement(url)) {
		        statement.setString(1, produto.getNome());
		        statement.setDouble(2, produto.getPreco()); // Supondo que o preço seja um valor numérico, ajuste o tipo de dado conforme necessário
		        statement.setInt(3, produto.getQuantidade()); // Supondo que a quantidade seja um valor inteiro, ajuste o tipo de dado conforme necessário
		        statement.setString(4, produto.getNomeForn());
		        statement.setString(5, produto.getDescricao());
		        statement.setBinaryStream(6, fis, tamanho);

		        statement.executeUpdate();
		        System.out.println("Produto inserido com sucesso!");
		    } catch (SQLException e) {
		        System.out.println("Erro ao inserir o produto: " + e.getMessage());
		        throw e; 
		    } finally {
		        
		        if (fis != null) {
		            try {
		                fis.close();
		            } catch (IOException e) {
		                System.out.println("Erro ao fechar FileInputStream: " + e.getMessage());
		            }
		        }
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
	public void BuscarProduto(JTextField txtId,JTextField txtNome,JTextField txtPreco,JTextField txtNomeFornecedor,JTextField txtQuantEsto,JTextField txtDescricao) {
		
		 String url = "SELECT *FROM produtos WHERE nome= ?";
     try { 
    	 conn=new Conexao().getConnection();
    	 stm = conn.prepareStatement(url);
    	 stm.setString(1,txtNome.getText());
    	 rs=stm.executeQuery();
    	 
  		if (rs.next()) {
  			
          txtId.setText(rs.getString("id"));
          txtNomeFornecedor.setText(rs.getString("nome_fornecedor"));
		  txtPreco.setText(rs.getString("preco"));
		  txtQuantEsto.setText(rs.getString("quantidade"));
          txtDescricao.setText(rs.getString("descricao"));
          
  		}else {
			 JOptionPane.showInternalMessageDialog(null, "Produto não cadastrado");
             conn.close();
  		}
    	  
    	  
     }catch (Exception e) {
     }
		// TODO: handle exception
	}
	 

   public void insertfornecimento(ModelFornecimento fnc) {
		 
	   String url="INSERT INTO Fornecimento(data,quantidadeForn,quantidadeEsto,nome_prduto,id_produto,nome_fornecedor,preçoProd) VALUES (?, ?, ?, ?, ?, ?, ?)";
	   
	   try (PreparedStatement statement = conn.prepareStatement(url)) {
					 
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        Date dataNasc = new Date(sdf.parse(fnc.getDataFornec()).getTime());
	        statement.setDate(1, dataNasc);
	        
		    statement.setInt(2, fnc.getQuantideForn());
	        statement.setInt(3, fnc.getQuantidadeEstoque()); 
	        statement.setString(4,fnc.getNomeProduto()); // Supondo que a quantidade seja um valor inteiro, ajuste o tipo de dado conforme necessário
	        statement.setInt(5, fnc.getIdProduto());
	        statement.setString(6, fnc.getNomeFornecedor());
	        statement.setDouble(7,fnc.getPrecoProduto());

		
	        int confirma = statement.executeUpdate();

	        if (confirma == 1) {
	            JOptionPane.showMessageDialog(null, "Fornecimento Registrado!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Não foi possível registrar!");
	        }
	    } catch (SQLException | ParseException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Erro ao registrar fornecimento: " + e.getMessage());
	    }
	   
	}
	
}


