package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ViewMenuAdministrador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel painelF= new JPanel();
    JButton btnfornecedores= new JButton("FORNECEDORES");

	public ViewMenuAdministrador(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
		this.setSize(1500,750);		
		this.setVisible(true);
		this.setTitle("Menu Administrador");
		getContentPane().setLayout(null);
		
		JButton btnFuncinarios = new JButton("FUNCIONARIOS");
		btnFuncinarios.setBounds(509, 120, 200, 33);
		getContentPane().add(btnFuncinarios);
		
		JButton btnFornecimento = new JButton("FORNECIEMENTO");
		btnFornecimento.setBounds(509, 190, 200, 33);
		getContentPane().add(btnFornecimento);
		btnFornecimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                painelF.setVisible(true);
            	painelF.setBounds(0,0,300,750);
            	painelF.setBackground(Color.WHITE);
            	painelF.add(btnfornecedores);
            	btnfornecedores.setBounds(30,100,200,50);
            	
            }
        });
		
		btnfornecedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewContrlForn();
            }
        });
		
		getContentPane().add(painelF);
		painelF.setVisible(false);
		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.setBounds(509, 250, 200, 33);
		getContentPane().add(btnEstoque);
		
		JButton btnHisDeV = new JButton("HISTORICO DE VENDAS");
		btnHisDeV.setBounds(509, 325, 200, 39);
		getContentPane().add(btnHisDeV);
		
	}
	public static void main(String[] args) {
		
		new ViewMenuAdministrador();
	}
}
