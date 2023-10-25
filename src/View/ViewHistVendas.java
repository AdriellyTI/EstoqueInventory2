package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerPagamentos;

public class ViewHistVendas extends JFrame {
	
	
	JButton btnVoltar= new JButton();
	ControllerPagamentos objCP = new ControllerPagamentos();
	
	ImageIcon img = new ImageIcon(getClass().getResource("HistóricoVendasImg.PNG"));
	JLabel label = new JLabel(img);
	
	public ViewHistVendas() {
		
	this.setSize(1500,750);		
	this.setVisible(true);
	this.setTitle("Histórico de Vendas");
	getContentPane().setLayout(null);
	
	label.setBounds(-60,0,1500,750);
	getContentPane().add(label);
	
	JScrollPane scTabela= new JScrollPane();
	scTabela.setBounds(400,180,850,400);
	
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
			tabela.getColumnModel().getColumn(3).setPreferredWidth(76);
			tabela.getColumnModel().getColumn(4).setPreferredWidth(76);
			tabela.getColumnModel().getColumn(5).setPreferredWidth(180);

			objCP.relatórioVendas(tabela);
			
			btnVoltar.setBounds(150,620,200,35);
			btnVoltar.setOpaque(false);
			btnVoltar.setContentAreaFilled(false);
			btnVoltar.setBorderPainted(false);
			
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
	public static void main(String [] args) {
		new ViewHistVendas();
	}
 
}
