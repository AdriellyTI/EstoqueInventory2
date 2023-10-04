package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.ModelPagamentos;
import Model.ModelProduto;

public class PagamentosDAO {
	
	Connection conn;
	
    PreparedStatement stm ;
	 ResultSet rs;
	
	
	public void insertRecibo(ModelPagamentos recibo) { 
	
		String url="INSERT INTO Recibo (nomeCliente,data,numeroDePecas,valorTotal,formaPagamento) VALUES('"+recibo.getNomeCliente()+"','"+recibo.getDataVenda()+"','"+recibo.getNumeroPecas()+"','"+recibo.getValorTotal()+"','"+recibo.getFormaPagamento()+"')";
	
         try {
			
			Connection conn =new Conexao().getConnection();

			stm = conn.prepareStatement(url);
			
			stm.execute();
			
			conn.close();

		
		}catch (Exception e) {
			 JOptionPane.showInternalMessageDialog(null, e);
		}
		
	}
	public List<ModelPagamentos> relatórioVendas(){
		 
		 List <ModelPagamentos> listaAcesso = new ArrayList<ModelPagamentos>();
		 
		 String url = "SELECT codigoVenda,data,nomeCliente,numeroDePecas,valorTotal,formaPagamento FROM Recibo";
		 
			try {
				
	             Connection conn =new Conexao().getConnection();

				stm = conn.prepareStatement(url);
				rs=stm.executeQuery();
		

			 while(rs.next()) {
				 ModelPagamentos p= new ModelPagamentos();
				
				 p.setCodigo(rs.getInt("codigoVenda"));
				 p.setDataVenda(rs.getString("data"));
				 p.setNomeCliente(rs.getString("nomeCliente"));
				 p.setNumeroPecas(rs.getInt("numeroDePecas"));
				 p.setValorTotal(rs.getDouble("valorTotal"));
				 p.setFormaPagamento(rs.getString("formaPagamento"));
				 
				 listaAcesso.add(p);
			 }
			 
			 }catch (Exception e) {
				 JOptionPane.showInternalMessageDialog(null, e);
				}
			 return listaAcesso;

	 }
	
}