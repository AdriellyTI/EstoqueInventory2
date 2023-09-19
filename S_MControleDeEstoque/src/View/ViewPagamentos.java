package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControllerPagamentos;

public class ViewPagamentos extends JFrame {

	ControllerPagamentos recibo;
	
	JButton efetuar= new JButton();
	JButton cancelar= new JButton();
	
	JTextField nomeClienteF= new JTextField();
	JTextField dataF= new JTextField();
	JTextField numeroPecasF= new JTextField();
	JTextField valorTotalF= new JTextField();
	JTextField formaPagamentoCb= new JTextField();
	
	public void initComponents() {
		
		JPanel panel= new JPanel();
        panel.setLayout(null);
        
        nomeClienteF.setBounds(115,155,450,25);
        dataF.setBounds(637,165,227,25);
        numeroPecasF.setBounds(120,280,270,25);
        valorTotalF.setBounds(120,375,270,25);
        formaPagamentoCb.setBounds(580,365,270,25);
        
        ImageIcon img = new ImageIcon(getClass().getResource("TelaPagamentos.PNG"));
		JLabel label = new JLabel(img);
		label.setBounds(0,0,1000,600);
        
        efetuar.setBounds(270,500,170,40);
        efetuar.setOpaque(false);
		efetuar.setContentAreaFilled(false);
		efetuar.setBorderPainted(false);
		
        efetuar.addActionListener((new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			String nomeCliente=nomeClienteF.getText();
			String dataVenda= dataF.getText();
			int numeroPecas=Integer.parseInt(numeroPecasF.getText());
			double valorTotal=Double.parseDouble(valorTotalF.getText());
			String formaPagamento=formaPagamentoCb.getText();
		
			recibo= new ControllerPagamentos();
			recibo.Pagamentos(nomeCliente, dataVenda, numeroPecas, valorTotal, formaPagamento);
		
			}
        }));
	
	
	
        cancelar.setBounds(556,500,170,40);
        cancelar.setOpaque(false);
		cancelar.setContentAreaFilled(false);
		cancelar.setBorderPainted(false);
		cancelar.addActionListener((new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				

			}
        }));
		
        add(panel);
        panel.add(label);
        panel.add(nomeClienteF);
        panel.add(dataF);
        panel.add(numeroPecasF);
        panel.add(valorTotalF);
         panel.add(formaPagamentoCb);
        panel.add(efetuar);
        panel.add(cancelar);
        
		setSize(1020,650);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public ViewPagamentos() {
		initComponents();
	}
	public static void main(String [] args) {
		new ViewPagamentos();
		
	}

}
