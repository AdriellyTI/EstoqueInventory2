package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ControllerLogin;


public class ViewEntrar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font fonte= new Font("Georgia",Font.BOLD,30);
    Color cor = new Color(22,114,186);
   
    
	JTextField nomeField = new JTextField(20);
	JPasswordField senhaField = new JPasswordField(20);
	JButton login = new JButton("LOGIN");
	JButton voltar = new JButton("VOLTAR");
	
//	Font fonte2= new Font("Georgia",Font.LAYOUT_LEFT_TO_RIGHT,20);
    Font fonte2 = new Font("Arial",Font.LAYOUT_NO_LIMIT_CONTEXT,20);

	
    public ViewEntrar(){
    	
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1600,900);
        
 		JPanel panel = new JPanel();
 		JLabel label = new JLabel(new ImageIcon(ViewEntrar.class.getResource("/Imagens/TelaEntrar.PNG")));
 		panel.setLayout(null);
 		
         label.setBounds(-120,-70,1600,900);
         panel.add(label);		
         
         nomeField.setBounds(515,350,350,35);
	     nomeField.setBackground(cor);
	     nomeField.setBorder(null);
	     nomeField.setForeground(Color.WHITE);
	     nomeField.setFont(fonte2);
	      
	    senhaField.setBounds(515, 450, 350, 30);
	    senhaField.setBackground(cor);
	    senhaField.setBorder(null);
	    
		login.setBounds(582,573,200,45);
		login.setBackground(Color.white);
		login.setFont(new Font("Calibri", Font.BOLD, 25));
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
		
		
		
		
		panel.add(nomeField);
		panel.add(senhaField);
		panel.add(login);
		panel.add(voltar);
		
		getContentPane().add(panel);
		this.setVisible(true);
//		this.setLayout(null);
//		setLocationRelativeTo(null);

	}


	
}
	