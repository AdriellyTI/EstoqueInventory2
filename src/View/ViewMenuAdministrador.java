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

public class ViewMenuAdministrador extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton btnVoltarF= new JButton();
	JButton btnVoltarFun= new JButton("V");
	JButton btnVoltarEsto= new JButton("V");

	JPanel painelF= new JPanel();
    JButton btnfornecedores= new JButton("");
    JButton btnCadastrForn= new JButton("CADASTRAR FORNECEDORES");
    JButton btnHistForn=new JButton("HISTÓRICO DE FORNECIMENTO");
    
    JPanel painelFun= new JPanel();
    JButton btnFunAtivo= new JButton("FUNCIOÁRIOS ATIVOS");
    JButton btnExcluirFun=new JButton("EXCLUIR FUNCIONÁRIO");
    
    JPanel painelEsto= new JPanel();
    JButton btnAdicionar = new JButton("ADICIONAR PRODUTO");
    JButton btnVerEsto= new JButton("VISUALIZAR ESTOQUE");
    Border borda=BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE);
    
	JLabel label = new JLabel(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgMenuAdm.PNG")));
	
	Color cor= new Color(232, 232, 232);
	int x = 280;
    int y=0;
	public ViewMenuAdministrador(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
		this.setSize(1500,750);		
		this.setVisible(true);
		this.setTitle("Menu Administrador");
		getContentPane().setLayout(null);
		painelF.setBackground(UIManager.getColor("EditorPane.selectionBackground"));
		
		//CONFIGURAÇOES GERAIS
		getContentPane().add(painelF);
		getContentPane().add(painelFun);
		getContentPane().add(painelEsto);
		
		label.setBounds(-60,0,1500,750);
		getContentPane().add(label);
		
		JButton btnFuncionarios = new JButton("FUNCIONÁRIOS");
		btnFuncionarios.setFont(new Font("Arial Black", Font.BOLD, 18));
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
		btnVendas.setFont(new Font("Arial Black", Font.BOLD, 18));
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
		btnFornecimento.setFont(new Font("Arial Black", Font.BOLD, 16));
		btnFornecimento.setBounds(1028, 584, 200, 51);
		getContentPane().add(btnFornecimento);
		btnFornecimento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	  if ( y == 0 ) {
                      painelF.show();
                      painelF.setSize (x, 785);
                       Thread th = new Thread() {
                           @Override
                           public void run() {
                               try {
                                   for (int i = 0; i <=  x;  i++) {
                                       Thread.sleep(1); 
                                       painelF.setSize(i, 785);
                                   }
                               }catch (Exception e){
                                   JOptionPane.showMessageDialog(null, e);
                               }
                           }
                           };th.start();
                           x = 280;
                       }
            	painelFornecedores();
            }
        });
		
		 btnFornecimento.addMouseListener(new MouseAdapter () {

		public void mouseExited(MouseEvent arg0) {
			btnFornecimento.setBackground(Color.WHITE);
			btnFuncionarios.setBackground(Color.WHITE);
			btnVendas.setBackground(Color.WHITE);
			
		}

		public void mouseEntered(MouseEvent arg0) {
			btnFornecimento.setBackground(cor);
			btnFuncionarios.setBackground(cor);
		}

		 });
		
		painelF.setVisible(false);
		painelFun.setVisible(false);
		painelEsto.setVisible(false);

		JButton btnEstoque = new JButton("ESTOQUE");
		btnEstoque.setFont(new Font("Arial Black", Font.BOLD, 18));
		btnEstoque.setBackground(Color.WHITE);

		btnEstoque.setBounds(668, 584, 200, 57);
		getContentPane().add(btnEstoque);
		btnEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	painelEstoque();
            }
        });
	}
	
	public void painelFornecedores() {
		
		
		  painelF.setVisible(true);
		  painelF.setLayout(null);
		  painelF.setBounds(0,0,300,750);
		  painelF.setBackground(new Color(22,144,186));

		  btnfornecedores.setBounds(30,75,200,64);
		  btnfornecedores.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnForn.PNG")));
	      btnfornecedores.setBorder(borda);
		  btnfornecedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewContrlForn();
                dispose();

                }
        });
		
		btnCadastrForn.setBounds(30,150,200,64);
		btnCadastrForn.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnForn2.PNG")));
		btnCadastrForn.setBorder(borda);
		btnCadastrForn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewFornecedor();
                dispose();
            }
        });
		
		btnHistForn.setBounds(30,250,200,64);
		btnHistForn.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnForn3.PNG")));
		btnHistForn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewHistFornec();
                dispose();
            }
        });
		btnVoltarF.setBounds(30,0,60,35);
		btnVoltarF.setIcon(new ImageIcon(ViewMenuAdministrador.class.getResource("/Imagens/imgBtnMenu.PNG")));
		btnVoltarF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 if ( x == 280 ) {
                     painelF.setSize (280, 785);
                     Thread th = new Thread() {
                         @Override
                         public void run() {
                             try {
                                 for (int i = 280; i >=0;  i--) {
                                     Thread.sleep(1); 
                                     painelF.setSize(i, 785);
                                 }
                             }catch (Exception e){
                                 JOptionPane.showMessageDialog(null, e);
                             }
                         }
                             };th.start();
                     x=0;
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
		painelFun.setBounds(0,0,300,750);
		painelFun.setBackground(Color.WHITE);
		
		
		btnFunAtivo.setBounds(30,100,200,30);
		btnFunAtivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            //	new ViewCtrlFuncionarios();
            }
        });
		btnExcluirFun.setBounds(30,150,200,30);
		btnExcluirFun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewExclusaoFun();
                dispose();
            }
        });
		btnVoltarFun.setBounds(250,500,50,35);
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
		painelEsto.setBounds(0,0,300,750);
		painelEsto.setBackground(Color.WHITE);
		

		painelEsto.add(btnAdicionar);
		painelEsto.add(btnVerEsto);
		painelEsto.add(btnVoltarEsto);

		btnVerEsto.setBounds(30,150,200,30);
		btnVerEsto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewEstoque();
                dispose();
            }
        });
		btnAdicionar.setBounds(30,100,200,30);
		btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewCadastroProduto();
                dispose();
            }
        });
		
		btnVoltarEsto.setBounds(250,500,50,35);
		btnVoltarEsto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	painelEsto.setVisible(false);
            }
        });

	}
	public static void main(String [] args) {
		new ViewMenuAdministrador();
	}
}