package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewPagamentos extends JFrame {

	JButton efetuar= new JButton();
	JButton cancelar= new JButton();
	
	JTextField nomeClienteF= new JTextField();
	JTextField dataF= new JTextField();
	JTextField numeroPecasF= new JTextField();
	JTextField valorTotalF= new JTextField();
	
	public void initComponents() {
		
		JPanel panel= new JPanel();
        panel.setLayout(null);
        
        efetuar.setBounds(250,500,150,40);
        cancelar.setBounds(550,500,150,40);
        add(panel);
        panel.add(efetuar);
        panel.add(cancelar);
        
		setSize(900,700);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public ViewPagamentos() {
		initComponents();
	}
	public static void main(String [] args) {
		new ViewPagamentos();
		
	}

}
