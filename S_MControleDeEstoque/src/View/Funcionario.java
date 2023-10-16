package View;

import java.awt.Color;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.ControllerCadastro;

public class Funcionario extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Font fonte= new Font("Georgia",Font.BOLD,25);

	ControllerCadastro funcionario;

	public Funcionario() {
		
		funcionario= new ControllerCadastro();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CADASTRO DE FUNCIONÁRIO");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
	    ImageIcon img = new ImageIcon(getClass().getResource("ImagemCadastroFunc.PNG"));
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
        nomeField.setBounds(400,175,550,30);
        
        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(400,248,550,30);
        
        JTextField dataNascField = new JTextField(20);
        dataNascField.setBounds(400,320,550,30);
        
        JTextField telefoneField = new JTextField(20);
       telefoneField.setBounds(400,393,550,30);
        
        JTextField emailField= new JTextField(20);
        emailField.setBounds(400,460,550,30);
       
        JPasswordField senhaField= new JPasswordField(20);
       senhaField.setBounds(400,533,550,30); 

        JButton cadastrarButton = new JButton("SALVAR");
        cadastrarButton.setBackground(Color.BLACK);
        cadastrarButton.setForeground(Color.white);
        cadastrarButton.setBounds(460,604,170,40);
        cadastrarButton.setFont(fonte);

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String senha= senhaField.getText();
                String nome = nomeField.getText();
                String userName= usernameField.getText();
                String dataNasc = dataNascField.getText();
                String telefone = telefoneField.getText();
                String email= emailField.getText();
               
                funcionario.CadastroFunc(nome, userName, dataNasc, telefone, email,senha);
                    
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

       
        panel.add(nomeField);
        panel.add(usernameField);   
        panel.add(dataNascField);
        panel.add(telefoneField);
        panel.add(emailField);
        panel.add(senhaField);
        panel.add(voltarButton);
        panel.add(cadastrarButton);

        add(panel);
        panel.setVisible(true);
        setVisible(true);
    }

    private void limparCampos() {
        // Método para limpar os campos após o cadastro
        // Pode ser implementado aqui
    }
//    public static void main(String [] args) {
//    	new Funcionario();
//   	}
}
