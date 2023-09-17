package Controller;

import java.sql.Connection;

import Model.ModelPagamentos;
import ModelDAO.Conexao;
import ModelDAO.PagamentosDAO;

public class ControllerPagamentos {

	public void Pagamentos(String nomeCliente,String dataVenda,int numeroPecas,double valorTotal,String formaPagamento) {
	
		ModelPagamentos venda=new ModelPagamentos(nomeCliente,dataVenda,numeroPecas,valorTotal,formaPagamento);
		
		 Connection conexao =new Conexao().getConnection();
		 
		 PagamentosDAO pagamento= new PagamentosDAO();
	
		 pagamento.insertRecibo(venda);
	}
	
	
}
