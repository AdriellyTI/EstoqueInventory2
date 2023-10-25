package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.IntBuffer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controller.ControllerProduto;
import Model.ModelProduto;
import ModelDAO.ProdutoDAO;

public class ViewCompraAdm extends JFrame {

    JTextField txtData=new JTextField();
    JTextField txtQuant= new JTextField();
    JTextField txtId =new JTextField();	
    
    JTextField txtNome =new JTextField();
    JTextField txtPreco =new JTextField();	

    Font fonte = new Font("Arial",Font.LAYOUT_NO_LIMIT_CONTEXT,20);
    JButton btnVoltar = new JButton();
    
    ImageIcon img = new ImageIcon(getClass().getResource("produtoImg.PNG"));
  	JLabel label = new JLabel(img);
 	ControllerProduto obj= new ControllerProduto();
//	 ModelProduto p= new ModelProduto();

  	private JTextField txtNomeFornecedor;
  	private JTextField txtDescricao;
  	private final JTextField txtQuantEsto = new JTextField();
  	 
	public ViewCompraAdm() {
		
		this.setSize(1500,750);		
		this.setVisible(true);
		this.setTitle("Fornecimeto");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		label.setBounds(-50,-27,1477,820);
		
		btnVoltar.setBounds(53, 11, 62, 55);
	    btnVoltar.setOpaque(false);
  		btnVoltar.setContentAreaFilled(false);
	    btnVoltar.setBorderPainted(false);

		txtData.setBounds(515,194,189,30);
		txtData.setFont(fonte);
		
		txtQuantEsto.setBounds(899, 494, 200, 30);
		txtQuantEsto.setColumns(10);
		txtQuantEsto.setFont(fonte);
		

		txtNome.setBounds(546,431,300,30);
		txtNome.setFont(fonte);

		txtId.setBounds(515,330,189,35);
		txtId.setFont(fonte);
		
		txtQuant.setBounds(517,264,189,35);
		txtQuant.setFont(fonte);
		
		txtPreco.setBounds(899,431,146,30);
		txtPreco.setFont(fonte);
		
		txtNomeFornecedor = new JTextField();
		txtNomeFornecedor.setBounds(546, 494, 300, 30);
		txtNomeFornecedor.setColumns(10);
		txtNomeFornecedor.setFont(fonte);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(546, 563, 300, 74);
		txtDescricao.setColumns(10);
		txtDescricao.setFont(fonte);
		

		btnVoltar.addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewMenuAdministrador();
				dispose();
			}
        }));
		JButton btnBuscar = new JButton("BUSCAR\r\n");
		btnBuscar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setBounds(774, 330, 117, 32);
//		btnBuscar.addActionListener((new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (txtId.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "O campo 'id' não foi prenchido.");
//					txtId.requestFocus();
//				}else {
//				obj.MostrarDadosProdutos(txtId,txtNome,txtPreco,txtNomeFornecedor,txtQuantEsto,txtDescricao);
//			}
//				}
//        }));
		JButton btnReporEsto = new JButton("Adicionar\r\n");
		btnReporEsto.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnReporEsto.setBounds(959, 607, 168, 30);
		btnReporEsto.addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String dataFornec= txtData.getText();
				int quantidade=Integer.parseInt (txtQuant.getText ()); 
				String idProduto= txtId.getText (); 
				//obj.reporProduto(dataFornec, quantidade, idProduto);
			}
        }));
		
		getContentPane().add(label);
		getContentPane().add(txtData);
		getContentPane().add(txtNome);
		getContentPane().add(txtId);
		getContentPane().add(txtQuant);
		getContentPane().add(txtPreco);
		getContentPane().add(txtNomeFornecedor);
		getContentPane().add(txtDescricao);
		getContentPane().add(txtQuantEsto);
		getContentPane().add(btnVoltar);
		getContentPane().add(btnBuscar);
		getContentPane().add(btnReporEsto);
		

		
	}
}
