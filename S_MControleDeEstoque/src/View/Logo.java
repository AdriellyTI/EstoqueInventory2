package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
//import javax.swing.*;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Logo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font fonte= new Font("Georgia",Font.BOLD,20);

	public Logo() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(1600,900);
       
		JPanel panel = new JPanel();
	    ImageIcon img = new ImageIcon(getClass().getResource("ImagemLogo.png"));
		JLabel label = new JLabel(img);
		panel.setLayout(null);
	//	setUndecorated (true);
		
        label.setBounds(-120,-130,1600,900);
		
        panel.add(label);
		
		JButton cadastrarButton= new JButton("CADASTRAR");
	    cadastrarButton.setBackground(Color.white);
	    cadastrarButton.setFont(fonte);
	    cadastrarButton.setBounds(824,628,170,35);
        cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Cadastrar();
			}
        });
	    
		JButton entrarButton = new JButton("ENTRAR");
		entrarButton.setBackground(Color.white);	
		entrarButton.setFont(fonte);
		entrarButton.setBounds(824,562,170,35);
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
