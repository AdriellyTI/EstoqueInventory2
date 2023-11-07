package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Model.CadastroFuncionario;

public class ViewMenuFuncionario extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btnPerfil = new JButton();
	JPanel painelUsuario = new JPanel();
	JLabel lblPerfil=new JLabel("Seu Perfil");
	JLabel lblFotoUser = new JLabel();
	JLabel lblNomeUser = new JLabel("Nome de Usuário:");
	JLabel lblNomeUserRet= new JLabel("");
	JLabel lblNomeCompleto = new JLabel("Nome Completo:");
	JLabel lblNomeCompletoRet = new JLabel("");
	JLabel lblIdadeUser = new JLabel("Idade:");
	JLabel lblIdadeUserRet = new JLabel("");
	JLabel lblEmailUser = new JLabel("E-MAIL:");
	JLabel lblEmailUserRet= new JLabel("");
    JButton btnVoltarPerfil=new JButton();
    JButton btnSairConta=new JButton();
    JLabel lblTelefone= new JLabel("Telefone");
	JLabel teleRet= new JLabel("");
	Border borda2= BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE);
	int x = 280;
	int y = 0;
	int a=300;
	//parametros interface
	public ViewMenuFuncionario(){
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(1373, 768);
		this.setVisible(true);
		this.setTitle("Menu Funcionario");
		//this.setResizable(false);
		this.setLocationRelativeTo(null);

		getContentPane().setLayout(null);
		painelUsuario.setVisible(false);
		getContentPane().add(painelUsuario);
		JLabel label = new JLabel(new ImageIcon(ViewMenuFuncionario.class.getResource("/Imagens/imgMenuFunc.PNG")));

		label.setBounds(-61, 0, 1500, 760);
		getContentPane().add(label);
		
		JButton estoqueButton = new JButton("VISUALIZAR ESTOQUE");
		estoqueButton.setBounds(804,430,207,50);
		
		estoqueButton.setOpaque(false);
		estoqueButton.setContentAreaFilled(false);
		estoqueButton.setBorderPainted(false);
		
		estoqueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
               new ViewEstoque(); 	
              // dispose();
			}
		});
		
		JButton pagamentoButton = new JButton("VENDA");
		pagamentoButton.setBounds(804,611,207,50);
		pagamentoButton.setOpaque(false);
		pagamentoButton.setContentAreaFilled(false);
		pagamentoButton.setBorderPainted(false);

		pagamentoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
               new ViewPagamentos();				
               dispose();
			}
		});
		
		JButton reporButton = new JButton("ESTOQUE+");
		reporButton.setBounds(804,236,207,59);
		reporButton.setOpaque(false);
		reporButton.setContentAreaFilled(false);
		reporButton.setBorderPainted(false);

		 
		 reporButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                 new ViewFornecimento();			
                 dispose();
			}
		});
			

		 btnPerfil.setBounds(86,11,41,35);
		 getContentPane().add(btnPerfil);
		 btnPerfil.setOpaque(false);
		 btnPerfil.setContentAreaFilled(false);
		 btnPerfil.setBorderPainted(false);
		 btnPerfil.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (y == 0) {
						painelUsuario.show();
						painelUsuario.setSize(a, 785);
						Thread th = new Thread() {
							@Override
							public void run() {
								try {
									for (int i = 0; i <= a; i++) {
										Thread.sleep(1);
										painelUsuario.setSize(i, 785);
									}
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, e);
								}
							}
						};
						th.start();
						a = 300;
					}
					mostrarPerfilUsuario();
				}
			});

		 getContentPane().add(estoqueButton);
		 getContentPane().add(pagamentoButton);
		 getContentPane().add(reporButton);
	}
	
	public void mostrarPerfilUsuario() {
		btnPerfil.setEnabled(false);
		btnPerfil.setVisible(false);
		
		painelUsuario.setVisible(true);
		painelUsuario.setLayout(null);
		painelUsuario.setBounds(0, 0, 300, 750);
		painelUsuario.setBackground(new Color(22, 115, 187));
		painelUsuario.setBorder(borda2);
		
		btnVoltarPerfil.setBounds(10,20,30,30);
		btnVoltarPerfil.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnSairPerfil.PNG")));
		btnVoltarPerfil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (a == 300) {
					painelUsuario.setSize(420, 785);
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								for (int i = 300; i >= 0; i--) {
									Thread.sleep(1);
									painelUsuario.setSize(i, 785);
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e);
							}
						}
					};
					th.start();
					a = 0;
				}
				btnPerfil.setEnabled(true);
				btnPerfil.setVisible(true);
			}
		});

		lblPerfil.setBounds(50,25,200,25);
		lblPerfil.setFont(new Font("Tox Typewriter",Font.BOLD,25));
		lblPerfil.setForeground(Color.white); 

		lblFotoUser.setBounds(50, 90, 150, 150);
		lblFotoUser.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgPerfil.PNG")));
		lblFotoUser.setBorder(borda2);
		
		lblNomeUser.setBounds(20,290,400,20);
		lblNomeUser.setFont(new Font("Georgia",Font.BOLD,20));
		lblNomeUser.setForeground(Color.white); 
		lblNomeUserRet.setBounds(20,322,200,20);
		lblNomeUserRet.setFont(new Font("Tox Typewriter",Font.BOLD,20));
		lblNomeUserRet.setForeground(Color.WHITE);
		
		lblNomeCompleto.setBounds(20,370,400,20);
		lblNomeCompleto.setFont(new Font("Georgia",Font.BOLD,20));
		lblNomeCompleto.setForeground(Color.WHITE);
		lblNomeCompletoRet.setFont(new Font("Tox Typewriter",Font.BOLD,20));
		lblNomeCompletoRet.setForeground(Color.WHITE);
		lblNomeCompletoRet.setBounds(20,400,400,20);
		
		lblEmailUser.setBounds(20,450,400,20);
		lblEmailUser.setFont(new Font("Georgia",Font.BOLD,20));
		lblEmailUser.setForeground(Color.white);
		lblEmailUserRet.setBounds(20,490,200,20);
		lblEmailUserRet.setFont(new Font("Tox Typewriter",Font.BOLD,20));
		lblEmailUserRet.setForeground(Color.WHITE);
		
		lblIdadeUser.setBounds(20,530,400,20);
		lblIdadeUser.setFont(new Font("Georgia",Font.BOLD,20));
		lblIdadeUser.setForeground(Color.WHITE);
		lblIdadeUserRet.setBounds(20,563,200,20);
		lblIdadeUserRet.setFont(new Font("Tox Typewriter",Font.BOLD,20));
		lblIdadeUserRet.setForeground(Color.WHITE);
		
		lblTelefone.setBounds(20,530,400,20);
		lblTelefone.setFont(new Font("Georgia",Font.BOLD,20));
		lblTelefone.setForeground(Color.WHITE);

		teleRet.setBounds(20,563,200,20);
		teleRet.setFont(new Font("Tox Typewriter",Font.BOLD,20));
		teleRet.setForeground(Color.WHITE);
		
		btnSairConta.setBounds(10,600,130,30);
		btnSairConta.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnSairConta.PNG")));
		btnSairConta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Logo();
				dispose();
			}
		});

		
		painelUsuario.add(lblFotoUser);
		painelUsuario.add(lblNomeUser);
		painelUsuario.add(lblNomeUserRet);
		painelUsuario.add(lblNomeCompleto);
		painelUsuario.add(lblNomeCompletoRet);
		painelUsuario.add(lblEmailUser);
		painelUsuario.add(lblEmailUserRet);
		//painelUsuario.add(lblIdadeUser);
		//painelUsuario.add(lblIdadeUserRet);
		painelUsuario.add(lblPerfil);

		painelUsuario.add(lblTelefone);
		painelUsuario.add(teleRet);
        painelUsuario.add(btnVoltarPerfil);
        painelUsuario.add(btnSairConta);
        
        CadastroFuncionario obj= new CadastroFuncionario();
     obj.MostrarDadosUser(lblFotoUser, lblNomeUserRet, lblNomeCompletoRet, lblEmailUserRet, teleRet);
        
	}
	
	public static void main(String [] args) {
		new ViewMenuFuncionario();
	}

}
