package ModelDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.ModelPagamentos;

public class PagamentosDAO {
	
	Connection conn;
	
    PreparedStatement stm ;
	ResultSet rs;
	
	public PagamentosDAO(Connection connection) {
		this.conn = connection;
	}
	
	public PagamentosDAO() {
		
	}
	
	public void insertRecibo(ModelPagamentos recibo) { 
	
		String url="INSERT INTO Recibo (nomeCliente,data,numeroDePecas,valorTotal,formaPagamento) VALUES( ?, ?, ?, ?, ?)";
	
         try(PreparedStatement stm = conn.prepareStatement(url))  {
			
        	    stm.setString(1, recibo.getNomeCliente());
        	    
        	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        	    Date dataVenda = new Date(sdf.parse(recibo.getDataVenda()).getTime());
        	    stm.setDate(2, dataVenda);
        	    
		        stm.setInt(3, recibo.getNumeroPecas());
		        stm.setDouble(4, recibo.getValorTotal());
		        stm.setString(5, recibo.getFormaPagamento());
		     
			
		        int confirma = stm.executeUpdate();

		        if (confirma == 1) {
		            JOptionPane.showMessageDialog(null, "Registro de Venda");
		        } else {
		            JOptionPane.showMessageDialog(null, "Erro");
		        }
		
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