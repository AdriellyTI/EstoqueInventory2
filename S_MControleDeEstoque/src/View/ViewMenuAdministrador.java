package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewMenuAdministrador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton voltar= new JButton("VOLTAR");
	JButton funcionarioButton= new JButton("FUNCIONARIO");
	JButton fornecedorButton= new JButton("FORNECEDOR");
	JButton estoqueButton= new JButton("ESTOQUE");


	
	//parametros de interface
	public ViewMenuAdministrador(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		funcionarioButton.setBounds(250,350,200,50);
		fornecedorButton.setBounds(590,350,200,50);
		estoqueButton.setBounds(900,350,200,50);



        voltar.setBounds(130, 570, 150,30);
        voltar.addActionListener(new ActionListener (){
        	
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new Logo();
        	}
        });
		
		add(voltar);
		add(funcionarioButton);
		add(fornecedorButton);
		add(estoqueButton);

		
		this.setLayout(null);
		this.setVisible(true);
		this.setTitle("Menu Administrador");
	}
	public static void main(String[] args) {
		
		new ViewMenuAdministrador();
	}
}
