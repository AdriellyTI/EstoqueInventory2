package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import Controller.ControllerProduto;

public class ViewFornecimento extends JFrame {

    JTextField txtData=new JTextField();
    JTextField txtQuant= new JTextField();
    JTextField txtId =new JTextField();	
    
    JTextField txtNome =new JTextField();
    JTextField txtPreco =new JTextField();	

    Font fonte = new Font("Arial",Font.LAYOUT_NO_LIMIT_CONTEXT,20);
    JButton btnVoltar = new JButton();
    ControllerProduto obj5= new ControllerProduto();

    Border borda=BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);

  	private JTextField txtNomeFornecedor;
  	private JTextField txtDescricao;
  	private final JTextField txtQuantEsto = new JTextField();
  	private final JTextField precoCompraField = new JTextField();
  	private final JLabel lblFoto = new JLabel();
  	private final JTextField precoTotalComField = new JTextField();
  	
	public ViewFornecimento() {
		
		

		JPanel panel = new JPanel();
        JLabel label = new JLabel(new ImageIcon(ViewFornecimento.class.getResource("/Imagens/imgTelaReporProduto.png")));
		label.setBounds(10, 0, 1356, 749);
		panel.setLayout(null);
		
		precoTotalComField.setBounds(144, 589, 189, 30);
		precoTotalComField.setColumns(10);
		precoTotalComField.setFont(fonte);
		precoTotalComField.setBorder(borda);
		
		precoCompraField.setBounds(144, 375, 189, 30);
		precoCompraField.setColumns(10);
		precoCompraField.setBorder(borda);
		
		lblFoto.setIcon(new ImageIcon(ViewFornecimento.class.getResource("/Imagens/imgProduto.PNG")));
		lblFoto.setBounds(800, 165, 117, 118);

		btnVoltar.setBounds(53, 11, 62, 55);
	    btnVoltar.setOpaque(false);
  		btnVoltar.setContentAreaFilled(false);
	    btnVoltar.setBorderPainted(false);

		txtData.setBounds(144,253,189,30);
		txtData.setFont(fonte);
		txtData.setBorder(borda);
		
		txtQuantEsto.setBounds(956, 226, 200, 30);
		txtQuantEsto.setColumns(10);
		txtQuantEsto.setFont(fonte);
		txtQuantEsto.setBorder(borda);

		txtNome.setBounds(144,452,361,30);
		txtNome.setFont(fonte);
        txtNome.setBorder(borda);
        
		txtId.setBounds(956,174,177,22);
		txtId.setFont(fonte);
		txtId.setBorder(borda);
		
		txtQuant.setBounds(144,315,209,30);
		txtQuant.setFont(fonte);
		txtQuant.setBorder(borda);
		
		txtPreco.setBounds(966,435,146,30);
		txtPreco.setFont(fonte);
		txtPreco.setBorder(borda);
		
		txtNomeFornecedor = new JTextField();
		txtNomeFornecedor.setBounds(956, 288, 300, 30);
		txtNomeFornecedor.setColumns(10);
		txtNomeFornecedor.setFont(fonte);
        txtNomeFornecedor.setBorder(borda);
        
		txtDescricao = new JTextField();
		txtDescricao.setBounds(966, 365, 300, 47);
		txtDescricao.setColumns(10);
		txtDescricao.setFont(fonte);
        txtDescricao.setBorder(borda);
        
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

				obj5.MostrarDadosProdutos(txtId,txtNome,txtQuantEsto,txtPreco,txtNomeFornecedor,txtDescricao,lblFoto);
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
		
		this.setVisible(true);
		this.setSize(1600,900);
		this.setLocationRelativeTo(null);
		
		panel.add(lblFoto);
		getContentPane().add(panel);
        panel.add(label);
		panel.add(txtData);
	    panel.add(txtNome);
		panel.add(txtId);
		panel.add(txtQuant);
		panel.add(txtPreco);
		panel.add(txtNomeFornecedor);
		panel.add(txtDescricao);
		panel.add(txtQuantEsto);
		panel.add(btnVoltar);
		panel.add(btnBuscar);
		panel.add(btnReporEsto);
		panel.add(precoCompraField);
		
		panel.add(precoTotalComField);
		panel.setVisible(true);
		
	}
	public static void main(String [] args) {
	     new ViewFornecimento();	
	}
}
