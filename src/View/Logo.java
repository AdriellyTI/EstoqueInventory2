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
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Logo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font fonte= new Font("Georgia",Font.BOLD,20);
    Border borda=BorderFactory.createLineBorder(Color.BLACK, 3, false);
	public Logo() {
		
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setSize(1350, 750);
       
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon(Logo.class.getResource("/Imagens/ImagemLogo.png")));
		panel.setLayout(null);
		//setUndecorated (true);
		this.setLocationRelativeTo(null);

        label.setBounds(-120,-130,1600,900);
		
        panel.add(label);
		
		JButton cadastrarButton= new JButton("CADASTRAR");
		cadastrarButton.setForeground(new Color(0, 0, 0));
	    cadastrarButton.setBackground(Color.white);
	    cadastrarButton.setFont(new Font("Tox Typewriter", Font.PLAIN, 20));
	    cadastrarButton.setBounds(824,586,170,35);
	    cadastrarButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Cadastrar();
				dispose();
			}
        });
	    
		JButton entrarButton = new JButton("ENTRAR");
		entrarButton.setForeground(new Color(0, 0, 0));
		entrarButton.setBackground(Color.WHITE);	
		entrarButton.setFont(new Font("Tox Typewriter", Font.PLAIN, 20));
		entrarButton.setBounds(824,528,170,35);
		entrarButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
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
		         
		  	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
