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
		//panel.setBackground(Color.orange);
	    ImageIcon img = new ImageIcon(getClass().getResource("TelaCadastrar.png"));
		JLabel label = new JLabel(img);
		panel.setLayout(null);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int labelWidth = img.getIconWidth();
		int labelHeight = img.getIconHeight();
		int x = (screenSize.width - labelWidth) / 2;
		int y = (screenSize.height - labelHeight) / 2;
		label.setBounds(x, y, labelWidth, labelHeight);

		panel.add(label);
		
		JButton administrador= new JButton("ADMINISTRADOR");
		administrador.setBounds(250,330,220,40);
		administrador.setBackground(Color.WHITE);
		administrador.setFont(fonte);
		
		  administrador.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new Administrador();
					
				}
	        });
		
		JButton fornecedor= new JButton("FORNECEDOR");
		fornecedor.setBounds(570,330,220,40);
		fornecedor.setBackground(Color.WHITE);
	    fornecedor.setFont(fonte);
	    fornecedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ViewFornecedor();
				
			}
        });
		
	    JButton funcionario= new JButton("FUNCIONÁRIO");
		funcionario.setBounds(890,330,220,40);
		funcionario.setBackground(Color.WHITE);
	    funcionario.setFont(fonte);
	    funcionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Funcionario();
				
			}
        });
	    
		this.setTitle("Cadastro");;
	
		
		panel.setVisible(true);
		panel.add(administrador);
		panel.add(fornecedor);
		panel.add(funcionario);
		this.setVisible(true);
		
		add(panel);
	}
	
//	public static void main(String[] args) {
//		
//		new Cadastrar();
//	}
}