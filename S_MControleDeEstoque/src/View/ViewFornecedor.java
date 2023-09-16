package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ControllerCadastro;


public class ViewFornecedor extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font fonte= new Font("Georgia",Font.BOLD,25);
     
	ControllerCadastro fornecedor;
	 
	public ViewFornecedor() {
		 
		fornecedor= new ControllerCadastro();
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CADASTRO DO(A) FORNECEDOR(A)");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
	    ImageIcon img = new ImageIcon(getClass().getResource("TelaFornecedor.png"));
		JLabel label = new JLabel(img);
		panel.setLayout(null);
		

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int labelWidth = img.getIconWidth();
		int labelHeight = img.getIconHeight();
		int x = (screenSize.width - labelWidth) / 2;
		int y = (screenSize.height - labelHeight) / 2;
		label.setBounds(x, y, labelWidth, labelHeight);

		panel.add(label);

        JTextField nomeField = new JTextField(20);
        nomeField.setBounds(400,175,580,30);
        
        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(400,250,580,30);
        
        JTextField cnpjField= new JTextField(20);
        cnpjField.setBounds(400,320,580,30);

        JTextField telefoneComercialField = new JTextField(20);
        telefoneComercialField.setBounds(400,390,580,30);

        JTextField emailComercialField = new JTextField(20);
        emailComercialField.setBounds(400,460,580,30);

        JTextField telefoneRepreField= new JTextField(20);
        telefoneRepreField.setBounds(400,520,580,30);
        
        JPasswordField senhaField = new JPasswordField(20);
        senhaField.setBounds(400,590,580,30);

        JButton cadastrarButton = new JButton("SALVAR");
        cadastrarButton.setBackground(Color.BLACK);
        cadastrarButton.setForeground(Color.white);
        cadastrarButton.setBounds(460,606,170,40);
        cadastrarButton.setFont(fonte);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String nome= nomeField.getText();
            	String userName=usernameField.getText();
            	String cnpj=cnpjField.getText();
            	String telefoneComercial=telefoneComercialField.getText();
            	String emailComercial=emailComercialField.getText();
            	String telefoneRepresentante=telefoneRepreField.getText();
            	String senha= senhaField.getText();
            	
            	ControllerCadastro fornecedor= new ControllerCadastro();
            	
            	fornecedor.CadastroForn(nome, userName, cnpj, telefoneComercial, emailComercial, telefoneRepresentante, senha);
                
             dispose();
            }
        });

        JButton voltarButton = new JButton("CANCELAR");
        voltarButton.setBounds(710,605,190,40);
        voltarButton.setBackground(Color.BLACK);
        voltarButton.setForeground(Color.white);
        voltarButton.setFont(fonte);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
               // new Cadastrar();
            }
        });
        


        panel.add(nomeField);
        panel.add(usernameField);
 
        panel.add(cnpjField);
  
        panel.add(telefoneComercialField);
    
        panel.add(emailComercialField);
        
        panel.add(telefoneRepreField);
       
        panel.add(senhaField);
        
        panel.add(new JLabel());
        panel.add(voltarButton);
        panel.add(new JLabel()); // Espaço vazio para layout
        panel.add(cadastrarButton);

        add(panel);
        panel.setVisible(true);
        setVisible(true);
    }
	
	
    private void limparCampos() {

    	
        // Método para limpar os campos após o cadastro
        // Pode ser implementado aqui
    }
     public static void main(String[] args) {
    	 new ViewFornecedor();
     }
     
}
