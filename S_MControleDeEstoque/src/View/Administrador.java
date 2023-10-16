
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControllerCadastro;
import Model.CadastroAdm;

public class Administrador extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font fonte= new Font("Georgia",Font.BOLD,25);
     
	private final ControllerCadastro controller;
	/**
	 * @wbp.nonvisual location=501,229
	 */
	JLabel lblFotoUser = new JLabel("");
	/**
	 * @wbp.nonvisual location=457,409
	 */
	
	private final JButton btnCarrFoto = new JButton("Carregar Foto");
	private FileInputStream fis;
	 private int tamanho;   
   
    public Administrador() {
		
		btnCarrFoto.setFont(new Font("Arial", Font.PLAIN, 13));
		btnCarrFoto.setBackground(Color.WHITE);
		controller= new ControllerCadastro();
		 
		lblFotoUser.setIcon(new ImageIcon(Administrador.class.getResource("/Imagens/imgFotoUser.PNG")));
        lblFotoUser.setBounds(380,201,154,148);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CADASTRO DO(A) ADMINISTRADOR(A)");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel panel = new JPanel();
	    ImageIcon img = new ImageIcon(getClass().getResource("ImagemCadastroAdm.PNG"));
		JLabel label = new JLabel(img);
		panel.setLayout(null);
		
		panel.add(lblFotoUser);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int labelWidth = img.getIconWidth();
		int labelHeight = img.getIconHeight();
		int x = (screenSize.width - labelWidth) / 2;
		int y = (screenSize.height - labelHeight) / 2;
		label.setBounds(10, 0, 1356, 749);

		panel.add(label);
		
  
        JTextField nomeField = new JTextField(20);
        nomeField.setBounds(350,435,282,30);

        JTextField userNameField = new JTextField(20);
        userNameField.setBounds(732,428,291,37);

        JTextField dataNascField = new JTextField(20);
        dataNascField.setBounds(350,520,282,30);

        JTextField telefoneField = new JTextField(20);
        telefoneField.setBounds(732,258,282,30);
         
        JTextField emailField = new JTextField(20);
        emailField.setBounds(732,337,282,30);
        
        JPasswordField senhaField = new JPasswordField();
        senhaField.setBounds(732,520,282,30);
        

     JButton cadastrarButton = new JButton("SALVAR");  
     cadastrarButton.setBackground(Color.WHITE);
     cadastrarButton.setForeground(Color.BLACK);
     cadastrarButton.setBounds(460,600,170,30);
     cadastrarButton.setFont(new Font("Arial", Font.BOLD, 23));

    cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                  String nome = nomeField.getText();
                  String userName= userNameField.getText();
                  String dataNasc = dataNascField.getText();
                  String email= emailField.getText();
                  String senha= senhaField.getText();
                  String telefone = telefoneField.getText();
            	
              try {
				controller.CadastrarUsuarioAdm(nome,userName,dataNasc,telefone,email,senha);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                dispose();
                //cddFoto.inserirFoto();
            }
        });

        JButton voltarButton = new JButton("CANCELAR");
        voltarButton.setBounds(710,600,180,39);
        voltarButton.setBackground(Color.WHITE);
        voltarButton.setForeground(Color.BLACK);
        voltarButton.setFont(new Font("Arial", Font.BOLD, 22));

        
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               new Logo(); 
            }
        });

    
        btnCarrFoto.setBounds(380,350,154,30);
        btnCarrFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarregarFoto();
            }
        });

   
       panel.add(nomeField);
        panel.add(userNameField);
        panel.add(dataNascField);
        panel.add(telefoneField);
        panel.add(emailField);
        panel.add(senhaField);
        panel.add(voltarButton);
        panel.add(cadastrarButton);
        panel.add(btnCarrFoto);

    	panel.setVisible(true);
		this.setVisible(true);
		getContentPane().add(panel);
	
    }
    public void CarregarFoto() {
    	JFileChooser jfcFoto= new JFileChooser();
    	jfcFoto.setDialogTitle("Selecionar Foto");
    	jfcFoto.setFileFilter(new FileNameExtensionFilter ("Arquivo de imagens(*.PNG,*.JPG,*.JPEG","png","jpg","jpeg"));
    	int resultado=jfcFoto.showOpenDialog(this);
    	if (resultado==JFileChooser.APPROVE_OPTION) {
    			 try {
    				     fis = new FileInputStream(jfcFoto.getSelectedFile());
    				     tamanho=(int)jfcFoto.getSelectedFile().length();
    				     Image foto= ImageIO.read(jfcFoto.getSelectedFile()).getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH);
    				     lblFotoUser.setIcon(new ImageIcon (foto));
    				     lblFotoUser.updateUI();
    				     CadastroAdm foto1=new CadastroAdm();
    				     foto1.setFis(fis);
    				     foto1.setTamanho(tamanho);
    			 }catch (Exception e) {
    				 e.printStackTrace();
    			 }
    		}    	}
    

    private void limparCampos() {
        
    }
   
    public static void main(String []args) {
    	new Administrador();
    }
}
