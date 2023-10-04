package Controller;

import java.sql.Connection;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.CadastroFornecedor;
import Model.ModelPagamentos;
import ModelDAO.Conexao;
import ModelDAO.PagamentosDAO;

public class ControllerPagamentos {

	PagamentosDAO obj3 = new PagamentosDAO();
	
	public void Pagamentos(String dataVenda,String nomeCliente,int numeroPecas,double valorTotal,String formaPagamento) {
	
		ModelPagamentos venda=new ModelPagamentos(dataVenda,nomeCliente,numeroPecas,valorTotal,formaPagamento);
		
		 Connection conexao =new Conexao().getConnection();
		 
		 PagamentosDAO pagamento= new PagamentosDAO();
	
		 pagamento.insertRecibo(venda);
	}
	
	public void relatórioVendas(JTable tabela) { 
		
		List<ModelPagamentos> lista=obj3.relatórioVendas();
				
   		DefaultTableModel modelo= (DefaultTableModel) tabela.getModel();
   		if (modelo.getRowCount()>0) {
   			modelo.setRowCount(0);
   		}
   		
   		for(ModelPagamentos p: lista ) {
   			
   			Object [] obj= new Object[6];
   			
   			obj[0]=p.getCodigo();
   			obj[1]=p.getDataVenda();
   			obj[2]=p.getNomeCliente();
   			obj[3]=p.getNumeroPecas();
   			obj[4]=p.getValorTotal();
   			obj[5]=p.getFormaPagamento();
   			
   			modelo.addRow(obj);
   		}
   	
	}
	
}
