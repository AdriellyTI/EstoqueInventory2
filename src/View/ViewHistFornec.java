package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewHistFornec extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField txtPesquisa= new JTextField();
	JButton btnVoltar= new JButton("V");
	
	public ViewHistFornec() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(1500,750);		
		this.setVisible(true);
		this.setTitle("Historico de Fornecimentos");
		getContentPane().setLayout(null);
		
		
		txtPesquisa.setBounds(680,100,350,30);
		btnVoltar.setBounds(250,300,100,35);

		JScrollPane scTabela= new JScrollPane();
		scTabela.setBounds(500,200,700,400);
		
		JTable tabela= new JTable();
		scTabela.setViewportView(tabela);
		
		btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ViewMenuAdministrador();
            	dispose();
            }
        });;
		
		tabela.setModel(new DefaultTableModel(
				   new Object[][] {		
					   
				   },
					new String [] {
							"Código","Data","Nome do Produto","Nome do Fornecedor","Quantidade "
					}
						
			  ));
				tabela.getColumnModel().getColumn(0).setPreferredWidth(76);
				tabela.getColumnModel().getColumn(1).setPreferredWidth(90);
				tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
				tabela.getColumnModel().getColumn(3).setPreferredWidth(200);
		
				
			      add(scTabela);
				 getContentPane().add(btnVoltar);
                 add(txtPesquisa);
	}
//         public static void main(String[] args) {
//        	 
//        	 new ViewHistFornec();
//         }
//	
}
