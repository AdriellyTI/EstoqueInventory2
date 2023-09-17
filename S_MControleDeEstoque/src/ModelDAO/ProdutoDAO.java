package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

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
		
		String url ="INSERT INTO Produto(idProduto,nome,preco,quantidadeEstoque,idFornecedor,descricao) VALUES('"+produt.getId()+"','"+produt.getNome()+"','"+ produt.getPreco()+"','"+ produt.getQuantidade()+"','"+ produt.getIdForn()+"',"+produt.getDescrição()+"')";
		
		
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
		 
		 
		 String url = "SELECT idProduto,nome,preco,quantidadeEstoque,idFornecedor,descricao FROM Produto";
		 
			try {
				
	             Connection conn =new Conexao().getConnection();

				stm = conn.prepareStatement(url);
				rs=stm.executeQuery();
		

			 while(rs.next()) {
				 ModelProduto p= new ModelProduto();
			     
				 p.setId(rs.getInt("idProduto"));
				 p.setNome(rs.getString("nome"));
				 p.setPreco(rs.getDouble("preco"));
				 p.setQuantidade(rs.getInt("quantidadeEstoque"));
				 p.setIdForn(rs.getInt("idFornecedor"));
				 p.setDescrição(rs.getString("descricao"));
				 
				 listaAcesso.add(p);
			 }
			 }catch (Exception e) {
				 JOptionPane.showInternalMessageDialog(null, e);
				}
			 return listaAcesso;


	 }
}
