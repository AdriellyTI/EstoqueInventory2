package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.ModelProduto;

public class ProdutoDAO {

	 Connection conn;
	 
	 PreparedStatement stm ;
	 ResultSet rs;
	
	public ProdutoDAO(Connection conn) {
		this.conn=conn;
	}
	
	public ProdutoDAO() {
		
	}
	
	public void insertProduto(ModelProduto produt)  {
		
		String url ="INSERT INTO produtos (nome,preco,quantidade,nome_fornecedor,descricao) VALUES('"+produt.getNome()+"','"+ produt.getPreco()+"','"+ produt.getQuantidade()+"','"+ produt.getNomeForn()+"','"+produt.getDescrição()+"')";
		
		
		try {
			
			Connection conn =new Conexao().getConnection();

			stm = conn.prepareStatement(url);
			
			stm.execute();
			
			conn.close();

		
		}catch (Exception e) {
			 JOptionPane.showInternalMessageDialog(null, e);
		}
	}
 
	
	 public List<ModelProduto> VerProdutos(){
		 
		 List <ModelProduto> listaAcesso = new ArrayList<ModelProduto>();
		 String url = "SELECT id,nome,preco,quantidade,nome_fornecedor,descricao FROM produtos";
		 
			try {
				
	             Connection conn =new Conexao().getConnection();

				stm = conn.prepareStatement(url);
				rs=stm.executeQuery();
		

			 while(rs.next()) {
				 ModelProduto p= new ModelProduto();
			     p.setId(rs.getInt("id"));
				 p.setNome(rs.getString("nome"));
				 p.setPreco(rs.getDouble("preco"));
				 p.setQuantidade(rs.getInt("quantidade"));
				 p.setNomeForn(rs.getString("nome_fornecedor"));
				 p.setDescrição(rs.getString("descricao"));
				 
				 listaAcesso.add(p);
			 }
			 }catch (Exception e) {
				 JOptionPane.showInternalMessageDialog(null, e);
				}
			 return listaAcesso;

	 }
		
	 public List<ModelProduto> pesquisarProdutos(String nome){
		 
		 List <ModelProduto> listaAcesso = new ArrayList<ModelProduto>();
		 String url = "SELECT *FROM produtos WHERE nome LIKE ?";
		 
			try {
				
	             Connection conn =new Conexao().getConnection();

				stm = conn.prepareStatement(url);
				stm.setString(1, "%"+nome+"%");
				rs=stm.executeQuery();
		

			 while(rs.next()) {
				 ModelProduto p= new ModelProduto();
			     p.setId(rs.getInt("id"));
				 p.setNome(rs.getString("nome"));
				 p.setPreco(rs.getDouble("preco"));
				 p.setQuantidade(rs.getInt("quantidade"));
				 p.setNomeForn(rs.getString("nome_fornecedor"));
				 p.setDescrição(rs.getString("descricao"));
				 
				 listaAcesso.add(p);
			 }
			 }catch (Exception e) {
				 JOptionPane.showInternalMessageDialog(null, e);
				}
			 return listaAcesso;

	 }
	
}
