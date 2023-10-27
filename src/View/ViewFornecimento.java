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

public class ViewFornecimento extends JFrame {

    JTextField txtData=new JTextField();
    JTextField txtQuant= new JTextField();
    JTextField txtId =new JTextField();	
    
    JTextField txtNome =new JTextField();
    JTextField txtPreco =new JTextField();	

    Font fonte = new Font("Arial",Font.LAYOUT_NO_LIMIT_CONTEXT,20);
    JButton btnVoltar = new JButton();
    ControllerProduto obj5= new ControllerProduto();

  	private JTextField txtNomeFornecedor;
  	private JTextField txtDescricao;
  	private final JTextField txtQuantEsto = new JTextField();
  	 
	public ViewFornecimento() {
		
		this.setSize(1500,750);		
		this.setVisible(true);
		this.setTitle("Fornecimeto");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
        JLabel label = new JLabel(new ImageIcon(ViewFornecimento.class.getResource("/Imagens/imgTelaReporProduto.png")));

		label.setBounds(10, 0, 1356, 749);
		getContentPane().add(label);
		
		btnVoltar.setBounds(53, 11, 62, 55);
	    btnVoltar.setOpaque(false);
  		btnVoltar.setContentAreaFilled(false);
	    btnVoltar.setBorderPainted(false);

		txtData.setBounds(99,256,189,30);
		txtData.setFont(fonte);
		
		txtQuantEsto.setBounds(899, 304, 200, 30);
		txtQuantEsto.setColumns(10);
		txtQuantEsto.setFont(fonte);
		

		txtNome.setBounds(99,387,361,30);
		txtNome.setFont(fonte);

		txtId.setBounds(899,181,189,32);
		txtId.setFont(fonte);
		
		txtQuant.setBounds(99,325,189,30);
		txtQuant.setFont(fonte);
		
		txtPreco.setBounds(899,367,146,30);
		txtPreco.setFont(fonte);
		
		txtNomeFornecedor = new JTextField();
		txtNomeFornecedor.setBounds(899, 238, 300, 30);
		txtNomeFornecedor.setColumns(10);
		txtNomeFornecedor.setFont(fonte);

		txtDescricao = new JTextField();
		txtDescricao.setBounds(899, 430, 300, 74);
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
		btnBuscar.setBounds(521, 385, 117, 32);
		btnBuscar.addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtNome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo 'id' não foi prenchido.");
					txtNome.requestFocus();
				}else {
				obj5.MostrarDadosProdutos(txtId,txtNome,txtQuantEsto,txtPreco,txtNomeFornecedor,txtDescricao);
			}
				}
        }));
		JButton btnReporEsto = new JButton("Adicionar\r\n");
		btnReporEsto.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnReporEsto.setBounds(497, 606, 168, 30);
		btnReporEsto.addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String dataFornec= txtData.getText();
				int quantidadeFornecida=Integer.parseInt (txtQuant.getText ()); 
				int quantidadeEstoque=Integer.parseInt(txtQuantEsto.getText());
				String nomeProduto=txtNome.getText();
				int idProduto=Integer.parseInt(txtId.getText ()) ;
				String nomeFornecedor=txtNomeFornecedor.getText();
				Double precoProduto=Double.parseDouble(txtPreco.getText());
				obj5.registrarFornecimento(dataFornec, quantidadeFornecida, quantidadeEstoque, nomeProduto, idProduto, nomeFornecedor, precoProduto);
			}
        }));
		
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
	public static void main(String [] args) {
	     new ViewFornecimento();	
	}
}
