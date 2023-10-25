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
        
        nomeClienteF.setBounds(505,247,428,32);
        dataF.setBounds(1027,343,189,25);
        numeroPecasF.setBounds(505,333,186,25);
        valorTotalF.setBounds(505,420,189,25);
        formaPagamentoCb.setBounds(1027,420,228,25);
        
		JLabel label = new JLabel(new ImageIcon(ViewPagamentos.class.getResource("/Imagens/TelaPagamentos.PNG")));
		label.setBounds(0,0,1370,735);
        
        efetuar.setBounds(505,531,156,40);
        efetuar.setOpaque(false);
		efetuar.setContentAreaFilled(false);
		efetuar.setBorderPainted(false);
		
        efetuar.addActionListener((new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			String dataVenda= dataF.getText();
			String nomeCliente=nomeClienteF.getText();
			int numeroPecas=Integer.parseInt(numeroPecasF.getText());
			double valorTotal=Double.parseDouble(valorTotalF.getText());
			String formaPagamento=formaPagamentoCb.getText();
		
			recibo= new ControllerPagamentos();
			recibo.Pagamentos(dataVenda,nomeCliente, numeroPecas, valorTotal, formaPagamento);
		
			}
        }));
	
	
	
        cancelar.setBounds(723,531,170,40);
        cancelar.setOpaque(false);
		cancelar.setContentAreaFilled(false);
		cancelar.setBorderPainted(false);
		cancelar.addActionListener((new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				

			}
        }));
		
        getContentPane().add(panel);
        panel.add(label);
        panel.add(nomeClienteF);
        panel.add(dataF);
        panel.add(numeroPecasF);
        panel.add(valorTotalF);
         panel.add(formaPagamentoCb);
        panel.add(efetuar);
        panel.add(cancelar);
        
		setSize(1500,750);
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
