package View;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
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

	JButton pesquisarB= new JButton("PESQUISAR"); 
	JButton voltarB= new JButton("VOLTAR"); 

	JTextField nomeProdutoField = new JTextField();
	JTextField idField= new JTextField();
	ControllerProduto p= new ControllerProduto();
	
	public ViewEstoque() {
		//tabela.setBounds(150,100,750,400);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		nomeProdutoField.setBounds(170,50,400,30);
		idField.setBounds(750,50,150,30);
		
		JScrollPane scTabela= new JScrollPane();
		scTabela.setBounds(130,100,650,440);
		
		JTable tabela= new JTable();
		scTabela.setViewportView(tabela);
		
		p.preencheTable(tabela);
		
		pesquisarB.setBounds(150,800,100,40);
		
		add(panel);
		//panel.add(tabela);
		panel.add(scTabela);
		//panel.add(idField);
		//panel.add(nomeProdutoField);
		setSize(950,600);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	
	
	public static void main (String [] args) {
		new ViewEstoque();
	}

}
