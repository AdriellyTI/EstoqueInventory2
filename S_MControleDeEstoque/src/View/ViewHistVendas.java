package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerPagamentos;

public class ViewHistVendas extends JFrame {
	
	
	JButton btnVoltar= new JButton();
	ControllerPagamentos objCP = new ControllerPagamentos();
	
	public ViewHistVendas() {
		
	this.setSize(1500,750);		
	this.setVisible(true);
	this.setTitle("Histórico de Vendas");
	getContentPane().setLayout(null);
	
	JScrollPane scTabela= new JScrollPane();
	scTabela.setBounds(500,200,850,400);
	
	JTable tabela= new JTable();
	scTabela.setViewportView(tabela);
	
	tabela.setModel(new DefaultTableModel(
			   new Object[][] {		
				   
			   },
				new String [] {
					"CÓDIGO","DATA","Nome do Cliente","Número de peças","Valor Total","Forma de Pagamento"
				}
				
		  ));
			tabela.getColumnModel().getColumn(0).setPreferredWidth(76);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(76);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(280);
			tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
			tabela.getColumnModel().getColumn(4).setPreferredWidth(100);
			tabela.getColumnModel().getColumn(5).setPreferredWidth(100);

			objCP.relatórioVendas(tabela);
			
			btnVoltar.setBounds(250,500,50,35);
			btnVoltar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	new ViewMenuAdministrador();
	            	dispose();
	            }
	        });
			
			
	add(scTabela);	
	add(btnVoltar);
	
	}
 
}
