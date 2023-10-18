package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.ControllerFornecedores;

public class ViewContrlForn extends JFrame {


	JPanel panel = new JPanel();
	ControllerFornecedores obj= new ControllerFornecedores();
	 ImageIcon img = new ImageIcon(getClass().getResource("TelaFornecedores.png"));
		JLabel label = new JLabel(img);
		
	public ViewContrlForn(){
		
		label.setBounds(-60,0,1500,750);
		getContentPane().add(label);
		
		JTextField txtNome= new JTextField();
		txtNome.setBounds(750,90,350,30);
		
		JScrollPane scTabela= new JScrollPane();
		scTabela.setBounds(450,200,800,400);
		
		JTable tabela= new JTable();
		scTabela.setViewportView(tabela);
		
		
		JButton btnVoltarCF= new JButton("V");
		btnVoltarCF.setBounds(250,500,50,35);
		
		panel.setLayout(null);
		panel.setBounds(500,200,800,400);
		
		tabela.setModel(new DefaultTableModel(
				   new Object[][] {		
					   
				   },
					new String [] {
							"Id","Nome da Empresa","CNPJ","Telefone C.","Email Comercial","Telefone R.","Produto Fornecido"
					}
						
			  ));
				tabela.getColumnModel().getColumn(0).setPreferredWidth(76);
				tabela.getColumnModel().getColumn(1).setPreferredWidth(280);
				tabela.getColumnModel().getColumn(2).setPreferredWidth(90);
				tabela.getColumnModel().getColumn(3).setPreferredWidth(199);
				tabela.getColumnModel().getColumn(4).setPreferredWidth(280);
				tabela.getColumnModel().getColumn(5).setPreferredWidth(280);
				tabela.getColumnModel().getColumn(6).setPreferredWidth(280);

				obj.preencheForn(tabela);
				
				btnVoltarCF.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            new ViewMenuAdministrador();
		            dispose();
		            }
		        });
				
		  getContentPane().setLayout(null);
		  add(scTabela);
		  add(txtNome);
		  add(btnVoltarCF);
	      this.setSize(1500,750);		
	      this.setVisible(true);
	      this.setTitle("Controle de Fornecedores");
	
	}

}
