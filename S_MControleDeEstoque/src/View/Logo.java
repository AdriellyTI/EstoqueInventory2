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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JPanel panel = new JPanel();
	    ImageIcon img = new ImageIcon(getClass().getResource("ImagemLogo.png"));
		JLabel label = new JLabel(img);
		panel.setLayout(null);
		

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int labelWidth = img.getIconWidth();
		int labelHeight = img.getIconHeight();
		int x = (screenSize.width - labelWidth) / 2;
		int y = (screenSize.height - labelHeight) / 2;
		label.setBounds(x, y, labelWidth, labelHeight);

		panel.add(label);
		
		JButton cadastrarButton= new JButton("CADASTRAR");
	    cadastrarButton.setBackground(Color.white);
	    cadastrarButton.setFont(fonte);
	    cadastrarButton.setBounds(600,630,170,35);
        cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				new Cadastrar();

			}
        });
	    
		JButton entrarButton = new JButton("ENTRAR");
		entrarButton.setBackground(Color.white);	
		entrarButton.setFont(fonte);
		entrarButton.setBounds(600,560,170,35);
		entrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
		         new ViewEntrar(); 
		         dispose();
			}
		});
		
		
		panel.add(cadastrarButton);
		panel.add(entrarButton);
		add(panel);
		setVisible(true);
	}
		

	   public static void main(String[] args) {
		     new Logo();
	}
}
