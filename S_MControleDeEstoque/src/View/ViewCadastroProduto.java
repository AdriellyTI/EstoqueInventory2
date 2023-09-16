package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ControllerProduto;

public class ViewCadastroProduto extends JFrame {

//	parametros de interface
	JButton cadastrarButton= new JButton("SALVAR");
	JButton cancelarButton = new JButton("CANCELAR");
	
	JTextField idField = new JTextField();
	JTextField nomeField = new JTextField();
	JTextField precoField = new JTextField();
	JTextField quantField = new JTextField();
	JTextField idFornField= new JTextField();
	JTextField descricaoField = new JTextField();
	

	public void InitComponents() {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		idField.setBounds(370,150,200,25);
		nomeField.setBounds(370,200,200,25);
		precoField.setBounds(370,250,200,25);
		quantField.setBounds(370,300,200,25);
		idFornField.setBounds(370,350,250,25);
		descricaoField.setBounds(370,400,300,50);
		
		cadastrarButton.setBounds(350,500,160,40);
        cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
               int id= Integer.parseInt(idField.getText());
               String nome=nomeField.getText();
               double preco=Double.parseDouble(precoField.getText());
               int quantidade=Integer.parseInt(quantField.getText());
               int idForn=Integer.parseInt(idFornField.getText());
               String descricao= descricaoField.getText();
               
               
               ControllerProduto product= new ControllerProduto();
               
               product.CadastrarProduto(id, nome, preco, quantidade, idForn, descricao);
               
			}
		});
		
		cancelarButton.setBounds(550,500,160,40);

		this.setVisible(true);
		this.setSize(1000,700);
		this.setLocationRelativeTo(null);
		
		add(panel);
		panel.setVisible(true);
		panel.add(idField);
		panel.add(nomeField);
		panel.add(precoField);
		panel.add(quantField);
		panel.add(idFornField);
		panel.add(descricaoField);
		panel.add(cadastrarButton);
		panel.add(cancelarButton);
	}
	
	public ViewCadastroProduto() {
		 InitComponents();
	}
	
	public static void  main(String[]args) {
		new ViewCadastroProduto();
	}
}
