package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
	
	
	public ViewEstoque() {
		
		JPanel panel = new JPanel();
		ImageIcon img = new ImageIcon(getClass().getResource("TelaEstoque.PNG"));
		JLabel labelImg= new JLabel(img);
		panel.setBounds(420,200,810,350);
		panel.setLayout(null);
		
		labelImg.setBounds(-10,50,1000,650);
		
		nomeProdutoField.setBounds(850,55,300,35);
		idField.setBounds(750,50,150,30);
		
		JScrollPane scTabela= new JScrollPane();
		scTabela.setBounds(0,0,800,450);
		scTabela.setBackground(cor);
		
		JTable tabela= new JTable();
		scTabela.setViewportView(tabela);
		
		
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
		
		voltarB.setBounds(130,600,150,30);

		voltarB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewMenuAdministrador();
            	dispose();
            }
        });
		
       	add(panel);
		panel.add(scTabela);
	    add(nomeProdutoField);
		add(labelImg);
		//add(voltarB);
		setSize(1500,750);
		setVisible(true);
		setLocationRelativeTo(null);

	}
	
}
