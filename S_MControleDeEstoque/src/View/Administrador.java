
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

public class Administrador extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Font fonte= new Font("Georgia",Font.BOLD,25);
     
	private final ControllerCadastro controller;
	
	public Administrador() {
		
		controller= new ControllerCadastro();
		
	
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CADASTRO DO(A) ADMINISTRADOR(A)");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel panel = new JPanel();
	    ImageIcon img = new ImageIcon(getClass().getResource("TelaCadastroAdministrador.png"));
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

        JTextField userNameField = new JTextField(20);
        userNameField.setBounds(400,250,580,30);

        JTextField dataNascField = new JTextField(20);
        dataNascField.setBounds(400,320,580,30);

        JTextField telefoneField = new JTextField(20);
        telefoneField.setBounds(400,390,580,30);
        telefoneField.setText("telefone");
         
        JTextField emailField = new JTextField(20);
        emailField.setBounds(400,470,580,30);
        
        JPasswordField senhaField = new JPasswordField();
        senhaField.setBounds(400,550,580,30);
        
        
     JButton cadastrarButton = new JButton("SALVAR");  
     cadastrarButton.setBackground(Color.BLACK);
     cadastrarButton.setForeground(Color.white);
     cadastrarButton.setBounds(460,606,170,40);
     cadastrarButton.setFont(fonte);

    cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                  String nome = nomeField.getText();
                  String userName= userNameField.getText();
                  String dataNasc = dataNascField.getText();
                  String email= emailField.getText();
                  String senha= senhaField.getText();
                  String telefone = telefoneField.getText();
            	
              controller.CadastrarUsuarioAdm(nome,userName,dataNasc,telefone,email,senha);
                
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
            
               new Logo(); 
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


    	panel.setVisible(true);
		this.setVisible(true);
		add(panel);
	
    }
	

    private void limparCampos() {
        
    }
    public static void main(String []args) {
    	new Administrador();
    }
    
}
