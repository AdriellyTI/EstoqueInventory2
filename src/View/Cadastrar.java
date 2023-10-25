package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cadastrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font fonte = new Font("Arial",Font.BOLD,20);
	
	Cadastrar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		

		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon(Cadastrar.class.getResource("/Imagens/TelaCadastrar.png")));
		panel.setLayout(null);
	
		label.setBounds(10, 0, 1356, 742);

		panel.add(label);
		
		JButton administrador= new JButton("ADMINISTRADOR");
		administrador.setBounds(329,500,242,45);
		administrador.setBackground(Color.WHITE);
		administrador.setFont(fonte);
		
		  administrador.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new Administrador();
					dispose();
					
				}
	        });
		
		
		
	    JButton funcionario= new JButton("FUNCIONÁRIO");
		funcionario.setBounds(807,500,249,45);
		funcionario.setBackground(Color.WHITE);
	    funcionario.setFont(fonte);
	    funcionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Funcionario();
				dispose();
				
			}
        });
	    
		this.setTitle("Cadastro");;
	
		
		panel.setVisible(true);
		panel.add(administrador);
		panel.add(funcionario);
		this.setVisible(true);
		
		getContentPane().add(panel);
	}
	
//	public static void main(String[] args) {
//		
//		new Cadastrar();
//	}
}