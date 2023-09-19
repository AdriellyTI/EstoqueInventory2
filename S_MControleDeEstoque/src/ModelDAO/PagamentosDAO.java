package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Model.ModelPagamentos;

public class PagamentosDAO {
	
	Connection conn;
	
    PreparedStatement stm ;
	
	
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
	
}