package View;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
//import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
//import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControllerCadastro;

public class Funcionario extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font fonte= new Font("Georgia",Font.BOLD,25);

	ControllerCadastro funcionario;
	JTextField nomeField = new JTextField(20);
	JTextField usernameField = new JTextField(20);
	JTextField dataNascField = new JTextField(20);
    private JButton btnCarrFoto = new JButton("Carregar Foto");
    private FileInputStream fis;
    private int tamanho;
    private JFileChooser jfcFoto = new JFileChooser();
    private JLabel lblFotoUser = new JLabel("");

    JTextField telefoneField = new JTextField(20);
    JTextField emailField= new JTextField(20);
    JPasswordField senhaField= new JPasswordField(20);
    /**
     * @wbp.nonvisual location=451,269
     */
    private final JLabel label_1 = new JLabel("");
    
	public Funcionario() {
		label_1.setIcon(new ImageIcon(Funcionario.class.getResource("/Imagens/imgFotoUser.PNG")));
		label_1.setBounds(380, 201, 154, 148);
		
		funcionario= new ControllerCadastro();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE FUNCIONÁRIO");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
		JLabel label = new JLabel(new ImageIcon(Funcionario.class.getResource("/Imagens/ImagemCadastroFunc.PNG")));
		panel.setLayout(null);
		panel.add(label_1);

//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int labelWidth = img.getIconWidth();
//		int labelHeight = img.getIconHeight();
//		int x = (screenSize.width - labelWidth) / 2;
//		int y = (screenSize.height - labelHeight) / 2;
		label.setBounds(10, 0, 1356, 749);

		panel.add(label);
		
        nomeField.setBounds(348,443,290,30);
        
        usernameField.setBounds(755,429,281,30);
        
        dataNascField.setBounds(348,522,290,30);
        
       telefoneField.setBounds(755,243,290,30);
        
        emailField.setBounds(757,330,287,30);
       
       senhaField.setBounds(759,505,273,30); 

        JButton cadastrarButton = new JButton("SALVAR");
        cadastrarButton.setBackground(Color.BLACK);
        cadastrarButton.setForeground(Color.white);
        cadastrarButton.setBounds(460,604,170,40);
        cadastrarButton.setFont(fonte);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   Cadastrar();
                    new Logo();
                    dispose();
   
            }
        });

        JButton voltarButton = new JButton("CANCELAR");
        voltarButton.setBounds(710,603,190,40);
        voltarButton.setBackground(Color.BLACK);
        voltarButton.setForeground(Color.white);
        voltarButton.setFont(fonte);
        
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Cadastrar();
            }
        });
        btnCarrFoto.setBounds(380, 350, 154, 30);
        btnCarrFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarregarFoto();
            }
        });
       
        panel.add(nomeField);
        panel.add(usernameField);   
        panel.add(dataNascField);
        panel.add(telefoneField);
        panel.add(emailField);
        panel.add(senhaField);
        panel.add(voltarButton);
        panel.add(cadastrarButton);
        panel.add(btnCarrFoto);
        getContentPane().add(panel);
        panel.setVisible(true);
        setVisible(true);
    }
	  private void CarregarFoto() {
		  
	        jfcFoto.setDialogTitle("Selecionar Foto");
	        jfcFoto.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens(.PNG,.JPG,*.JPEG)", "png", "jpg", "jpeg"));
	        int resultado = jfcFoto.showOpenDialog(this);
	        if (resultado == JFileChooser.APPROVE_OPTION) {
	            try {
	            	fis = new FileInputStream(jfcFoto.getSelectedFile());
	                tamanho = (int) jfcFoto.getSelectedFile().length();
	                Image foto = ImageIO.read(jfcFoto.getSelectedFile()).getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH);
	                lblFotoUser.setIcon(new ImageIcon(foto));
	                lblFotoUser.updateUI();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    
	    private void Cadastrar() {
	        try {
	            String nome = nomeField.getText();
	            String userName = usernameField.getText();
	            String dataNasc = dataNascField.getText();
	            String email = emailField.getText();
	            String senha = new String(senhaField.getPassword());
	            String telefone = telefoneField.getText();
                funcionario.CadastroFunc(nome, userName, dataNasc, telefone, email,senha,fis,tamanho);

	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	    }

    private void limparCampos() {
        // Método para limpar os campos após o cadastro
        // Pode ser implementado aqui
    }
//    public static void main(String [] args) {
//    	new Funcionario();
//   	}
}
