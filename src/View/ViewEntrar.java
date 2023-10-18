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
import javax.swing.JTextField;

import Controller.ControllerLogin;


public class ViewEntrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font fonte= new Font("Georgia",Font.BOLD,30);
    Color cor = new Color(162,125,200); 
    
    public ViewEntrar(){
    	
    	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTextField nomeField = new JTextField(20);
		JTextField senhaField = new JTextField(20);
		JButton login = new JButton("LOGIN");
		JButton voltar = new JButton("VOLTAR");
		
		
		JPanel panel = new JPanel();
		ImageIcon img = new ImageIcon(getClass().getResource("TelaEntrar.PNG"));
		JLabel labelImg= new JLabel(img);
		panel.setLayout(null);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int labelImgWidth = img.getIconWidth();
		int labelImgHeight = img.getIconHeight();
		int x = (screenSize.width - labelImgWidth) / 2;
		int y = (screenSize.height - labelImgHeight) / 2;
		labelImg.setBounds(x, y, labelImgWidth, labelImgHeight);
		
		nomeField.setBounds(520,320,400,35);
	    nomeField.setBackground(Color.white);

	    senhaField.setBounds(520, 420, 400, 35);
	    senhaField.setBackground(Color.white);
	    
	    panel.add(labelImg);
	    
		login.setBounds(580,615,200,45);
		login.setBackground(Color.white);
		login.setFont(fonte);
		login.addActionListener( new ActionListener() {

			//@Override
			public void actionPerformed(ActionEvent e) {
			    String  username= nomeField.getText();
			    String senha = senhaField.getText();
			    
			    ControllerLogin entrar= new ControllerLogin();
			    entrar.Autenticar(username, senha);
			    
			    dispose();
			}
		});
		
		voltar.setBounds(50, 650, 170, 35);
		voltar.setBackground(Color.white);
	
		voltar.addActionListener( new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				 
			dispose();
			new Logo();
				
			}
			
		});
		
		panel.setVisible(true);
		this.setVisible(true);
		add(panel);
		panel.add(nomeField);
		panel.add(senhaField);
		panel.add(login);
		panel.add(voltar);
	}


	
}
	