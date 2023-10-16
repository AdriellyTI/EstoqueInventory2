package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControllerProduto;

public class ViewCadastroProduto extends JFrame {

	JButton cadastrarButton= new JButton("SALVAR");
	JButton cancelarButton = new JButton("CANCELAR");
	
	JTextField nomeField = new JTextField();
	JTextField precoField = new JTextField();
	JTextField quantField = new JTextField();
	JTextField nomeFornField= new JTextField();
	JTextField descricaoField = new JTextField();
	
	ControllerProduto product= new ControllerProduto();
	

	public void InitComponents() {
		
		JPanel panel = new JPanel();
		ImageIcon img = new ImageIcon(getClass().getResource("TelaCadastroProd.PNG"));
		JLabel label = new JLabel(img);
		label.setBounds(-50,-10,1200,700);
		panel.setLayout(null);
		
		nomeField.setBounds(220,290,468,25);
		precoField.setBounds(222,350,172,25);
		quantField.setBounds(770,350,173,25);
		nomeFornField.setBounds(220,410,350,25);
		descricaoField.setBounds(220,470,540,50);
		
		cadastrarButton.setBounds(510,580,160,40);
	    cadastrarButton.setOpaque(false);
	    cadastrarButton.setContentAreaFilled(false);
		cadastrarButton.setBorderPainted(false);
        cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
               String nome=nomeField.getText();
               double preco=Double.parseDouble(precoField.getText());
               int quantidade=Integer.parseInt(quantField.getText());
               String nomeForn= nomeFornField.getText();
               String descricao= descricaoField.getText();
         
               product.CadastrarProduto(nome, preco, quantidade, nomeForn, descricao);
			}
		});
		
		cancelarButton.setBounds(268,580,160,40);
		cancelarButton.setOpaque(false);
	    cancelarButton.setContentAreaFilled(false);
		cancelarButton.setBorderPainted(false);  
		cancelarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				

			}
		});

		this.setVisible(true);
		this.setSize(1140,700);
		this.setLocationRelativeTo(null);
		
		add(panel);
		panel.add(label);
		panel.add(nomeField);
		panel.add(precoField);
		panel.add(quantField);
		panel.add(nomeFornField);
		panel.add(descricaoField);
		panel.add(cadastrarButton);
		panel.add(cancelarButton);
		panel.setVisible(true);
	}
	
	public ViewCadastroProduto() {
		 InitComponents();
	}
	
//	public static void  main(String[]args) {
//		new ViewCadastroProduto();
//	}
}
