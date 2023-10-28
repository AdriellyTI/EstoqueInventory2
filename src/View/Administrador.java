package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import Controller.ControllerCadastro;

public class Administrador extends JFrame {
    private static final long serialVersionUID = 1L;

    Font fonte = new Font("Georgia", Font.BOLD, 25);

    private final ControllerCadastro controller;
    private JLabel lblFotoUser = new JLabel("");
    private JButton btnCarrFoto = new JButton("Carregar Foto");
    private FileInputStream fis;
    private int tamanho;
    private JTextField nomeField = new JTextField(20);
    private JTextField userNameField = new JTextField(20);
    private JTextField dataNascField = new JTextField(20);
    private JTextField telefoneField = new JTextField(20);
    private JTextField emailField = new JTextField(20);
    private JPasswordField senhaField = new JPasswordField();
    private JFileChooser jfcFoto = new JFileChooser();

    public Administrador() {
        initializeUI();
        controller = new ControllerCadastro();
    }

    private void initializeUI() {
        btnCarrFoto.setFont(new Font("Arial", Font.PLAIN, 13));
        btnCarrFoto.setBackground(Color.WHITE);

        lblFotoUser.setIcon(new ImageIcon(Administrador.class.getResource("/Imagens/imgFotoUser.PNG")));
        lblFotoUser.setBounds(380, 201, 154, 148);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("CADASTRO DO(A) ADMINISTRADOR(A)");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(new ImageIcon(Administrador.class.getResource("/Imagens/ImagemCadastroAdm.PNG")));
        panel.setLayout(null);

        panel.add(lblFotoUser);
        label.setBounds(10, 0, 1356, 749);

        panel.add(label);

        nomeField.setBounds(345, 435, 282, 30);
        userNameField.setBounds(730, 428, 291, 37);
        dataNascField.setBounds(345, 520, 282, 30);
        telefoneField.setBounds(730, 258, 282, 30);
        emailField.setBounds(730, 337, 282, 30);
        senhaField.setBounds(730, 520, 282, 30);

        JButton cadastrarButton = new JButton("SALVAR");
        cadastrarButton.setBackground(Color.WHITE);
        cadastrarButton.setForeground(Color.BLACK);
        cadastrarButton.setBounds(460, 600, 170, 30);
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 23));

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cadastrar();
                new Logo();
                dispose();
            }
        });

        JButton voltarButton = new JButton("CANCELAR");
        voltarButton.setBounds(710, 600, 180, 39);
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

        btnCarrFoto.setBounds(380, 350, 154, 30);
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
            String userName = userNameField.getText();
            String dataNasc = dataNascField.getText();
            String email = emailField.getText();
            String senha = new String(senhaField.getPassword());
            String telefone = telefoneField.getText();
            controller.CadastrarUsuarioAdm(nome, userName, dataNasc, telefone, email, senha, fis, tamanho);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void main(String[] args) {
        new Administrador();
    }
}