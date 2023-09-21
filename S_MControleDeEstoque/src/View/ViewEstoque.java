package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;

import Controller.ControllerProduto;
import Model.ModelProduto;
import ModelDAO.ProdutoDAO;

public class ViewEstoque extends JFrame {

	Color cor = new Color(162,125,200); 
	ControllerProduto p= new ControllerProduto();

	JButton pesquisarB= new JButton("PESQUISAR"); 
	JButton voltarB= new JButton("VOLTAR"); 
	
	JTextField nomeProdutoField = new JTextField();
	JTextField idField= new JTextField();
	
	
	public ViewEstoque() {
		
		JPanel panel = new JPanel();
		ImageIcon img = new ImageIcon(getClass().getResource("TelaEstoque.PNG"));
		JLabel labelImg= new JLabel(img);
		panel.setBounds(115,180,760,390);
		panel.setLayout(null);
		
		labelImg.setBounds(-10,-25,1000,650);
		
		nomeProdutoField.setBounds(170,140,400,30);
		idField.setBounds(750,50,150,30);
		
		JScrollPane scTabela= new JScrollPane();
		scTabela.setBounds(40,20,700,380);
		scTabela.setBackground(cor);
		
		JTable tabela= new JTable();
		scTabela.setViewportView(tabela);
		
		p.preencheTable(tabela);
		
		pesquisarB.setBounds(580,140,160,30);
        pesquisarB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String desc=nomeProdutoField.getText();
                p.pesquisarProduto(tabela, desc);
			}
		});
		
		add(panel);
		panel.add(scTabela);
		add(nomeProdutoField);
		add(pesquisarB);
		add(labelImg);
		setSize(1000,650);
		setVisible(true);
		setLocationRelativeTo(null);

	}


	public static void main (String [] args) {
		new ViewEstoque();
	}

}
