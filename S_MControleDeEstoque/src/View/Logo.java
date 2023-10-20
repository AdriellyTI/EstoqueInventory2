package View;

import java.awt.Color;
import java.awt.Font;
//import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Logo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font fonte= new Font("Georgia",Font.BOLD,20);
    Border borda=BorderFactory.createLineBorder(Color.BLACK, 3, false);
	public Logo() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(1600,900);
       
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon(Logo.class.getResource("/Imagens/ImagemLogo.png")));
		panel.setLayout(null);
	//	setUndecorated (true);
		
        label.setBounds(-120,-130,1600,900);
		
        panel.add(label);
		
		JButton cadastrarButton= new JButton("CADASTRAR");
		cadastrarButton.setForeground(new Color(255, 255, 255));
	    cadastrarButton.setBackground(Color.white);
	    cadastrarButton.setFont(new Font("Georgia", Font.PLAIN, 20));
	    cadastrarButton.setBounds(824,586,170,35);
	    cadastrarButton.setBackground(new Color(22,144,186));
	    cadastrarButton.setBorder(borda);
        cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Cadastrar();
				dispose();
			}
        });
	    
		JButton entrarButton = new JButton("ENTRAR");
		entrarButton.setForeground(new Color(255, 255, 255));
		entrarButton.setBackground(Color.white);	
		entrarButton.setFont(new Font("Georgia", Font.PLAIN, 20));
		entrarButton.setBounds(824,528,170,35);
		entrarButton.setBackground(new Color(22,144,186));
		entrarButton.setBorder(borda);
		entrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		         new ViewEntrar(); 
		         dispose();
			}
		});
		JButton btnSair= new JButton();
		btnSair.setBounds(1000,0,50,20);
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		         dispose();
			}
		});
		
		panel.add(cadastrarButton); 
		panel.add(entrarButton);
		getContentPane().add(panel);
		//panel.add(btnSair);
		setVisible(true);
	}
		

	   public static void main(String[] args) {
		     new Logo();
	}
}
