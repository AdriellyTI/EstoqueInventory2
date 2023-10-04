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

	JButton btnVoltarF= new JButton("V");
	JButton btnVoltarFun= new JButton("V");
	JButton btnVoltarEsto= new JButton("V");

	JPanel painelF= new JPanel();
    JButton btnfornecedores= new JButton("FORNECEDORES");
    JButton btnCadastrForn= new JButton("CADASTRAR FORNECEDORES");
    JButton btnHistForn=new JButton("HISTÓRICO DE FORNECIMENTO");
    
    JPanel painelFun= new JPanel();
    JButton btnFunAtivo= new JButton("FUNCIOÁRIOS ATIVOS");
    JButton btnExcluirFun=new JButton("EXCLUIR FUNCIONÁRIO");
    
    JPanel painelEsto= new JPanel();
    JButton btncompra = new JButton("ADICIONAR PRODUTO");
    JButton btnVerEsto= new JButton("VISUALIZAR ESTOQUE");

    
    ViewCtrlFuncionarios obj = new ViewCtrlFuncionarios();
    
	public ViewMenuAdministrador(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
		this.setSize(1500,750);		
		this.setVisible(true);
		this.setTitle("Menu Administrador");
		getContentPane().setLayout(null);
		
		
		JButton btnFuncionarios = new JButton("FUNCIONARIOS");
		btnFuncionarios.setBounds(509, 120, 200, 33);
		getContentPane().add(btnFuncionarios);
		btnFuncionarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelFun.setVisible(true);
            }
        });
		
		JButton btnFornecimento = new JButton("FORNECIEMENTO");
		btnFornecimento.setBounds(509, 190, 200, 33);
		getContentPane().add(btnFornecimento);
		btnFornecimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                painelF.setVisible(true);	
            }
        });
		
		//FUNCIONALIDADES DOS BOTES DE FORNECEDORES
		btnfornecedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewContrlForn();
                dispose();

                }
        });
		
		btnCadastrForn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewFornecedor();
                dispose();
            }
        });
		
		btnHistForn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewHistFornec();
                dispose();
            }
        });
	//FUNCIONALIDADES DOS BOTÕES DE FUNCIONARIOS
		btnFunAtivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewCtrlFuncionarios();
                dispose();
            }
        });
		btnExcluirFun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewExclusaoFun();
                dispose();
            }
        });
	//FUNCIONALIDADES DOS BOTOES DE ESTOQUE
		btnVerEsto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewEstoque();
                dispose();
            }
        });
		btncompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewCompraAdm();
                dispose();
            }
        });
		//BOTÓES DE VOLTAR EM TODOS OS PAINEIS
		btnVoltarF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	painelF.setVisible(false);
            }
        });
		btnVoltarFun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	painelFun.setVisible(false);
            }
        });
		btnVoltarEsto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	painelEsto.setVisible(false);
            }
        });
		//PAINEL DE FORNECEDORES
		painelF.setLayout(null);
		painelF.setBounds(0,0,300,750);
		painelF.setBackground(Color.WHITE);
		
		btnfornecedores.setBounds(30,100,200,30);
		btnCadastrForn.setBounds(30,150,200,30);
		btnVoltarF.setBounds(250,500,50,35);
		btnHistForn.setBounds(30,200,200,30);
		
		painelF.add(btnfornecedores);
		painelF.add(btnCadastrForn);
		painelF.add(btnVoltarF);
		painelF.add(btnHistForn);
		
		//PAINEL DE FUNCIONARIOS
		painelFun.setLayout(null);
		painelFun.setBounds(0,0,300,750);
		painelFun.setBackground(Color.WHITE);
		
		btnFunAtivo.setBounds(30,100,200,30);
		btnExcluirFun.setBounds(30,150,200,30);
		btnVoltarFun.setBounds(250,500,50,35)
		;
		painelFun.add(btnFunAtivo);
		painelFun.add(btnExcluirFun);
		painelFun.add(btnVoltarFun);

		//PAINEL DE ESTOQUE
		painelEsto.setLayout(null);
		painelEsto.setBounds(0,0,300,750);
		painelEsto.setBackground(Color.WHITE);
		
		btncompra.setBounds(30,100,200,30);
		btnVerEsto.setBounds(30,150,200,30);
		btnVoltarEsto.setBounds(250,500,50,35);

		painelEsto.add(btncompra);
		painelEsto.add(btnVerEsto);
		painelEsto.add(btnVoltarEsto);

		//CONFIGURAÇOES GERAIS
		getContentPane().add(painelF);
		getContentPane().add(painelFun);
		getContentPane().add(painelEsto);

		painelF.setVisible(false);
		painelFun.setVisible(false);
		painelEsto.setVisible(false);

		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.setBounds(509, 250, 200, 33);
		getContentPane().add(btnEstoque);
		btnEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        		painelEsto.setVisible(true);
            }
        });
		JButton btnHisDeV = new JButton("HISTORICO DE VENDAS");
		btnHisDeV.setBounds(509, 325, 200, 39);
		getContentPane().add(btnHisDeV);
        btnHisDeV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        	       new ViewHistVendas();
        	       dispose();
            }
        });
		
	}

	public static void main(String[] args) {
		
		new ViewMenuAdministrador();
	}
}
