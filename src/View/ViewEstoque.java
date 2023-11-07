package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

import Controller.ControllerProduto;
import Model.ModelProduto;
import ModelDAO.ProdutoDAO;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.border.MatteBorder;

public class ViewEstoque extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Color cor = new Color(162,125,200);
	
	ControllerProduto p= new ControllerProduto();

	JButton voltarB= new JButton("VOLTAR"); 
	
	JTextField nomeProdutoField = new JTextField();
	JTextField idField= new JTextField();
	Border borda2= BorderFactory.createMatteBorder(5, 5, 5, 5, new Color( 22,115,187));
    JLabel lblPesquisa= new JLabel("Pesquisar");
	
	public ViewEstoque() {
		
		JPanel panel = new JPanel();
		panel.setBounds(new Rectangle(350, 400, 719, 419));
		JLabel labelImg= new JLabel(new ImageIcon(ViewEstoque.class.getResource("/Imagens/TelaEstoque.PNG")));
		panel.setBounds(200,157,900,419);
		panel.setLayout(null);
		panel.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(22, 115, 187)));
		
		labelImg.setBounds(-10,50,1000,650);
		nomeProdutoField.setBounds(new Rectangle(0, 300, 60, 25));
		lblPesquisa.setBounds(new Rectangle(200, 95, 100, 25));
		lblPesquisa.setBounds(200,85,100,30);
		nomeProdutoField.setBounds(350,95,300,30);
		idField.setBounds(750,50,150,30);
		
		JScrollPane scTabela= new JScrollPane();
		scTabela.setBounds(0,0,900,419);
		scTabela.setBackground(cor);
	
		JTable tabela= new JTable();
		scTabela.setViewportView(tabela);
	    tabela.setFont(new Font("Georgia", Font.PLAIN, 15));	
		tabela.setRowHeight(20);
		tabela.setShowHorizontalLines(true);
		tabela.setShowVerticalLines(true);
		tabela.setRowMargin(2);
		tabela.setModel(new DefaultTableModel(
				   new Object[][] {		
					   
				   },
					new String [] {
							"Id","Nome","Preço","Quantidade","Nome do Fornecedor","Descrição"
					}
						
			  ));
				tabela.getColumnModel().getColumn(0).setPreferredWidth(76);
				tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
				tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
				tabela.getColumnModel().getColumn(3).setPreferredWidth(199);
				tabela.getColumnModel().getColumn(4).setPreferredWidth(280);
				tabela.getColumnModel().getColumn(5).setPreferredWidth(360);
		
				p.preencheTable(tabela);
		
		nomeProdutoField.addKeyListener( new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				String desc=nomeProdutoField.getText();
                p.pesquisarProduto(tabela, desc);
							
			}
		});
		voltarB.setRequestFocusEnabled(false);
		voltarB.setOpaque(false);
		voltarB.setBounds(new Rectangle(10, 10, 20, 20));
		voltarB.setContentAreaFilled(false);
		voltarB.setBorderPainted(false);
		voltarB.setBounds(10,0,30,30);

		voltarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
		
       	getContentPane().add(panel);
		panel.add(scTabela);
	    getContentPane().add(nomeProdutoField);
		getContentPane().add(labelImg, BorderLayout.NORTH);
		getContentPane().add(voltarB);
		getContentPane().add(lblPesquisa);
		setSize(1350, 750);
		setVisible(true);
		setLocationRelativeTo(null);
		this.setResizable(false);


	}
	
}
