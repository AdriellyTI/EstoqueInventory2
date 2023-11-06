package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

import Controller.ControllerCadastro;

public class ViewMenuAdministrador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btnVoltarF = new JButton();
	JButton btnVoltarFun = new JButton("V");
	JButton btnVoltarEsto = new JButton("V");

	JPanel painelF = new JPanel();
	JButton btnfornecedores = new JButton("");
	JButton btnCadastrForn = new JButton("CADASTRAR FORNECEDORES");
	JButton btnHistForn = new JButton("HISTÓRICO DE FORNECIMENTO");

	JPanel painelFun = new JPanel();
	JButton btnFunAtivo = new JButton("FUNCIOÁRIOS ATIVOS");
	JButton btnExcluirFun = new JButton(" FUNCIONÁRIOS INATIVOS");

	JPanel painelEsto = new JPanel();
	JButton btnAdicionar = new JButton("ADICIONAR PRODUTO");
	JButton btnVerEsto = new JButton("VISUALIZAR ESTOQUE");
	Border borda = BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE);
	Border borda2= BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE);

	JButton btnPerfilUser = new JButton();
	JPanel painelUsuario = new JPanel();
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
    
	JLabel label = new JLabel(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgMenuAdm.PNG")));
	Color cor = new Color(232, 232, 232);
	int x = 280;
	int y = 0;
	int a=300;
	ControllerCadastro objC= new ControllerCadastro();
	
	public ViewMenuAdministrador() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(1350, 750);
		this.setVisible(true);
		this.setTitle("Menu Administrador");
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		getContentPane().setLayout(null);
		painelF.setBackground(UIManager.getColor("EditorPane.selectionBackground"));

		// CONFIGURAÇOES GERAIS
		getContentPane().add(painelF);
		getContentPane().add(painelFun);
		getContentPane().add(painelEsto);
		getContentPane().add(painelUsuario);

		label.setBounds(-61, 0, 1500, 750);
		getContentPane().add(label);

		JButton btnFuncionarios = new JButton("FUNCIONÁRIOS");
		btnFuncionarios.setFont(new Font("Tox Typewriter.ttf", Font.BOLD, 21));
		btnFuncionarios.setBackground(Color.WHITE);
		btnFuncionarios.setBounds(1028, 337, 200, 57);
		getContentPane().add(btnFuncionarios);
		btnFuncionarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painelFuncionarios();
			}
		});

		JButton btnVendas = new JButton("VENDAS");
		btnVendas.setBackground(Color.WHITE);
		btnVendas.setFont(new Font("Tox Typewriter.ttf", Font.BOLD, 25));
		btnVendas.setBounds(657, 337, 200, 57);
		getContentPane().add(btnVendas);
		btnVendas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnFornecimento = new JButton("FORNECIEMENTO");
		btnFornecimento.setBackground(Color.WHITE);
		btnFornecimento.setFont(new Font("Tox Typewriter.ttf", Font.BOLD, 21));
		btnFornecimento.setBounds(1028, 584, 200, 51);
		getContentPane().add(btnFornecimento);
		btnFornecimento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (y == 0) {
					painelF.show();
					painelF.setSize(x, 785);
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								for (int i = 0; i <= x; i++) {
									Thread.sleep(1);
									painelF.setSize(i, 785);
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e);
							}
						}
					};
					th.start();
					x = 280;
				}
				painelFornecedores();
			}
		});

		btnFornecimento.addMouseListener(new MouseAdapter() {

			public void mouseExited(MouseEvent arg0) {

			}

			public void mouseEntered(MouseEvent arg0) {

			}

		});

		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.setFont(new Font("Tox Typewriter.ttf", Font.BOLD, 25));
		btnEstoque.setBackground(Color.WHITE);

		btnEstoque.setBounds(668, 584, 200, 57);
		getContentPane().add(btnEstoque);
		btnEstoque.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painelEstoque();
			}
		});
		btnPerfilUser.setBounds(84,0,55,34);
		getContentPane().add(btnPerfilUser);
		btnPerfilUser.addActionListener(new ActionListener() {
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
		
		painelF.setVisible(false);
		painelFun.setVisible(false);
		painelEsto.setVisible(false);
		painelUsuario.setVisible(false);
		
	}

	public void painelFornecedores() {

		painelF.setVisible(true);
		painelF.setLayout(null);
	//	painelF.setBounds(0, 0, 300, 750);
		painelF.setBorder(borda);
		painelF.setBackground(new Color( 22,115,187));

		btnfornecedores.setBounds(30, 75, 200, 64);
		btnfornecedores.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnForn.PNG")));
		btnfornecedores.setBorder(borda);
		btnfornecedores.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewContrlForn();
				dispose();

			}
		});

		btnCadastrForn.setBounds(30, 150, 200, 64);
		btnCadastrForn.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnForn2.PNG")));
		btnCadastrForn.setBorder(borda);
		btnCadastrForn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewFornecedor();
				dispose();
			}
		});

		btnHistForn.setBounds(30, 250, 200, 64);
		btnHistForn.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnForn3.PNG")));
		btnHistForn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewHistFornec();
				dispose();
			}
		});
		btnVoltarF.setBounds(30, 0, 60, 35);
		btnVoltarF.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnMenu.PNG")));
		btnVoltarF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (x == 280) {
					painelF.setSize(280, 785);
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								for (int i = 280; i >= 0; i--) {
									Thread.sleep(1);
									painelF.setSize(i, 785);
								}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, e);
							}
						}
					};
					th.start();
					x = 0;
				}
			}
		});
		painelF.add(btnfornecedores);
		painelF.add(btnCadastrForn);
		painelF.add(btnVoltarF);
		painelF.add(btnHistForn);
	}

	public void painelFuncionarios() {

		painelFun.setVisible(true);
		painelFun.setLayout(null);
		painelFun.setBounds(0, 0, 300, 750);
		painelFun.setBackground(Color.WHITE);

		btnFunAtivo.setBounds(30, 100, 200, 30);
		btnFunAtivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				// new ViewCtrlFuncionarios();
			}
		});
		btnExcluirFun.setBounds(30, 150, 200, 30);
		btnExcluirFun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewExclusaoFun();
				dispose();
			}
		});
		btnVoltarFun.setBounds(250, 500, 50, 35);
		btnVoltarFun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painelFun.setVisible(false);
			}
		});

		painelFun.add(btnFunAtivo);
		painelFun.add(btnExcluirFun);
		painelFun.add(btnVoltarFun);

	}

	public void painelEstoque() {

		painelEsto.setVisible(true);
		painelEsto.setLayout(null);
		painelEsto.setBounds(0, 0, 300, 750);
		painelEsto.setBackground(Color.WHITE);

		painelEsto.add(btnAdicionar);
		painelEsto.add(btnVerEsto);
		painelEsto.add(btnVoltarEsto);

		btnVerEsto.setBounds(30, 150, 200, 30);
		btnVerEsto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewEstoque();
				dispose();
			}
		});
		btnAdicionar.setBounds(30, 100, 200, 30);
		btnAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewCadastroProduto();
				dispose();
			}
		});

		btnVoltarEsto.setBounds(250, 500, 50, 35);
		btnVoltarEsto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				painelEsto.setVisible(false);
			}
		});

	}

	public void mostrarPerfilUsuario() {
		btnPerfilUser.setEnabled(false);
		btnPerfilUser.setVisible(false);
		
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
				btnPerfilUser.setEnabled(true);
				btnPerfilUser.setVisible(true);
			}
		});

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
		painelUsuario.add(lblIdadeUser);
		painelUsuario.add(lblIdadeUserRet);
        painelUsuario.add(btnVoltarPerfil);
        painelUsuario.add(btnSairConta);
        
       objC.mostrarDados(lblFotoUser,lblNomeUserRet,lblNomeCompletoRet,lblEmailUserRet,lblIdadeUserRet);
	}

	public static void main(String[] args) {
		new ViewMenuAdministrador();
	}
}