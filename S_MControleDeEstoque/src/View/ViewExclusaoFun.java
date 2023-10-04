package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ViewExclusaoFun extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton btnVoltar = new JButton("V");

	JTextField txtNome = new JTextField();
	JTextField txtId= new JTextField();
     ImageIcon img = new ImageIcon(getClass().getResource("Funcionario.PNG"));
	 JLabel label = new JLabel(img);
	 
	 ImageIcon img2 = new ImageIcon(getClass().getResource("Funcionario2.PNG"));
	 JLabel label2 = new JLabel(img);
	 JPanel jpFuncionario= new JPanel();
	 
        public ViewExclusaoFun() {
        	
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		this.setSize(1200,700);		
		this.setVisible(true);
		this.setTitle("Controle de Funcionários");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		label.setBounds(100,40,150,150);
		label2.setVerticalAlignment(SwingConstants.BOTTOM);

		label2.setBounds(15,10,150,150);

		txtNome.setBounds(250,50,300,30);
		txtId.setBounds(250,100,150,30);
		jpFuncionario.setLayout(null);
		jpFuncionario.setBounds(100,200,800,350);
		jpFuncionario.setBackground(Color.WHITE);
		
		btnVoltar.setBounds(250,500,50,35);
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewMenuAdministrador();
            	dispose();
            }
        });

		getContentPane().add(txtNome);
		getContentPane().add(txtId);
		getContentPane().add(label);
		getContentPane().add(jpFuncionario);
		getContentPane().add(btnVoltar);

		jpFuncionario.add(label2);
        }
	
        public static void main(String[] args){
        	new ViewExclusaoFun();
        }
}

