package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControllerProduto;

public class ViewCadastroProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton cadastrarButton= new JButton("SALVAR");
	JButton cancelarButton = new JButton("CANCELAR");
	
	JTextField nomeField = new JTextField();
	JTextField precoField = new JTextField();
	JTextField quantField = new JTextField();
	JTextField nomeFornField= new JTextField();
	JTextField descricaoField = new JTextField();
	JLabel lblFotoP = new JLabel("");
    private JFileChooser jfcFoto = new JFileChooser();
    private FileInputStream fis;
    private int tamanho;
    private JButton btnCarrFoto = new JButton("Carregar Foto");

	ControllerProduto product= new ControllerProduto();
	

	public void InitComponents() {
		
		lblFotoP.setIcon(new ImageIcon(ViewCadastroProduto.class.getResource("/Imagens/imgFotoUser.PNG")));
		lblFotoP.setBounds(284, 205, 144, 150);
		
		btnCarrFoto.setFont(new Font("Arial", Font.PLAIN, 13));
        btnCarrFoto.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon(ViewCadastroProduto.class.getResource("/Imagens/TelaCadastroProd.PNG")));
		label.setBounds(10, 0, 1356, 749);
		panel.setLayout(null);
		
		panel.add(lblFotoP);
		
		nomeField.setBounds(172,511,390,25);
		precoField.setBounds(744,367,208,20);
		quantField.setBounds(744,289,208,25);
		nomeFornField.setBounds(741,204,390,20);
		descricaoField.setBounds(741,455,349,49);
		
		cadastrarButton.setBounds(501,590,160,40);
	    cadastrarButton.setOpaque(false);
	    cadastrarButton.setContentAreaFilled(false);
		cadastrarButton.setBorderPainted(false);
        cadastrarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
                Cadastrar();
			}
		});
        btnCarrFoto.setBounds(294, 362, 154, 30);
        btnCarrFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarregarFoto();
            }
        });
		
		cancelarButton.setBounds(30,0,71,60);
		cancelarButton.setOpaque(false);
	    cancelarButton.setContentAreaFilled(false);
		cancelarButton.setBorderPainted(false);  
		cancelarButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewMenuAdministrador();
				dispose();
			}
		});

		this.setVisible(true);
		this.setSize(1600,900);
		this.setLocationRelativeTo(null);
		
		getContentPane().add(panel);
		panel.add(label);
		panel.add(nomeField);
		panel.add(precoField);
		panel.add(quantField);
		panel.add(nomeFornField);
		panel.add(descricaoField);
		panel.add(cadastrarButton);
		panel.add(cancelarButton);
		panel.add(btnCarrFoto);
		panel.setVisible(true);
	}
	
	public ViewCadastroProduto() {
		 InitComponents();
	}
	private void CarregarFoto() {
        jfcFoto.setDialogTitle("Selecionar Foto");
        jfcFoto.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens(.PNG,.JPG,*.JPEG)", "png", "jpg", "jpeg"));
        int resultado = jfcFoto.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
            	fis = new FileInputStream(jfcFoto.getSelectedFile());
                tamanho = (int) jfcFoto.getSelectedFile().length();
                Image foto = ImageIO.read(jfcFoto.getSelectedFile()).getScaledInstance(lblFotoP.getWidth(), lblFotoP.getHeight(), Image.SCALE_SMOOTH);
                lblFotoP.setIcon(new ImageIcon(foto));
                lblFotoP.updateUI();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	 private void Cadastrar() {
	        try {
	        	 String nome=nomeField.getText();
	               double preco=Double.parseDouble(precoField.getText());
	               int quantidade=Integer.parseInt(quantField.getText());
	               String nomeForn= nomeFornField.getText();
	               String descricao= descricaoField.getText();
	         
	               product.CadastrarProduto(nome, preco, quantidade, nomeForn, descricao, fis, tamanho);
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	    }


	public static void  main(String[]args) {
		new ViewCadastroProduto();
	}
}
