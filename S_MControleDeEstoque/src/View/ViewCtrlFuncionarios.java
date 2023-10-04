package View;

import java.awt.Color;
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

import Controller.ControllerFuncionarios;

public class ViewCtrlFuncionarios extends JFrame{

	

	JButton btnVoltarCFun = new JButton("V");
	JButton btnFiltrar= new JButton();
	
	ControllerFuncionarios objCF= new ControllerFuncionarios();
	JTextField txtPesquisar= new JTextField();
	JPanel panelFiltrar= new JPanel();
	
	ImageIcon img = new ImageIcon(getClass().getResource("FuncionariosAtivos.PNG"));
	JLabel label = new JLabel(img);
	
	
	public ViewCtrlFuncionarios() {
		
		this.setSize(1500,750);		
		this.setVisible(true);
		this.setTitle("Controle de Funcionários");
		getContentPane().setLayout(null);
		
		label.setBounds(-60,0,1500,750);
		getContentPane().add(label);
		
		
		JScrollPane scTabela= new JScrollPane();
		scTabela.setBounds(550,200,700,400);
		
		JTable tabela= new JTable();
		scTabela.setViewportView(tabela);
		
		panelFiltrar.setBounds(300,100,400,400);
		panelFiltrar.setBackground(Color.white);
		txtPesquisar.setBounds(830,115,350,30);
		btnFiltrar.setBounds(910,100,50,50);
		
//		btnFiltrar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	
//            }
//        });
		
		btnVoltarCFun.setBounds(130,600,150,35);
		btnVoltarCFun.setOpaque(false);
		btnVoltarCFun.setContentAreaFilled(false);
		btnVoltarCFun.setBorderPainted(false);
		btnVoltarCFun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewMenuAdministrador();
            	dispose();
            }
        });
		
		tabela.setModel(new DefaultTableModel(
				   new Object[][] {		
					   
				   },
					new String [] {
							"ID","Nome Completo","Data de Nascimento","Telefone","email"
					}
						
			  ));
				tabela.getColumnModel().getColumn(0).setPreferredWidth(76);
				tabela.getColumnModel().getColumn(1).setPreferredWidth(280);
				tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
				tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
				tabela.getColumnModel().getColumn(4).setPreferredWidth(200);

				objCF.VerFuncionariosAtivos(tabela);
				
			      add(scTabela);        		
			      add(btnVoltarCFun);
			      add(txtPesquisar);
			     // add(btnFiltrar);
			      add(panelFiltrar);
			      panelFiltrar.setVisible(false);
			      }
	
	public static void main(String[]args) {
		new ViewCtrlFuncionarios();
	}

}
