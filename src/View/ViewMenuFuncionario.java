package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewMenuFuncionario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//parametros interface
	public ViewMenuFuncionario(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JPanel panel = new JPanel();
		ImageIcon img = new ImageIcon(getClass().getResource("TelaMenu.png"));
		JLabel label = new JLabel(img);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int labelWidth = img.getIconWidth();
		int labelHeight = img.getIconHeight();
		int x = (screenSize.width - labelWidth) / 2;
		int y = (screenSize.height - labelHeight) / 2;
		label.setBounds(x, y, labelWidth, labelHeight);
		
		panel.add(label);
		
		JButton estoqueButton = new JButton("");
		estoqueButton.setBounds(628,230,180,50);
		
		estoqueButton.setOpaque(false);
		estoqueButton.setContentAreaFilled(false);
		estoqueButton.setBorderPainted(false);
		
		estoqueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
               new ViewEstoque(); 				
			}
		});
		
		JButton pagamentoButton = new JButton("");
		pagamentoButton.setBounds(628,420,170,30);
		
	    pagamentoButton.setOpaque(false);
		pagamentoButton.setContentAreaFilled(false);
		pagamentoButton.setBorderPainted(false);
		
		pagamentoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
               new ViewPagamentos();				
			}
		});
		
		JButton cadastrarButton = new JButton();
		cadastrarButton.setBounds(628,600,180,50);
		 cadastrarButton.setOpaque(false);
	     cadastrarButton.setContentAreaFilled(false);
		 cadastrarButton.setBorderPainted(false);
		 
		 cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
               new ViewFornecimento();			
			}
		});
		
		panel.setLayout(null);
		panel.setVisible(true);
		this.setVisible(true);
		this.setTitle("Menu Funcionario");
		
		panel.add(estoqueButton);
		panel.add(pagamentoButton);
		panel.add(cadastrarButton);
		add(panel);
	}
	
//	public static void main(String [] args) {
//		new ViewMenuFuncionario();
//	}

}
