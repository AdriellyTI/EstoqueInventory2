package View;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ViewCompraAdm extends JFrame {

    JTextField txtData=new JTextField();
    JTextField txtQuant= new JTextField();
    
    JTextField txtNome =new JTextField();
    JTextField txtId =new JTextField();	
    JTextField txtDescriçao =new JTextField();	

    
    ImageIcon img = new ImageIcon(getClass().getResource("produtoImg.PNG"));
  	JLabel label = new JLabel(img);
  	 
	public ViewCompraAdm() {
		
		this.setSize(1200,700);		
		this.setVisible(true);
		this.setTitle("Fornecimeto");
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		label.setBounds(100,70,150,150);
		
		txtData.setBounds(300,50,150,30);
		txtNome.setBounds(300,100,300,30);
		txtId.setBounds(300,150,150,30);
		txtQuant.setBounds(300,200,150,30);
		
		add(label);
		add(txtData);
		add(txtNome);
		add(txtId);
		add(txtQuant);
	}
	public static void main (String[] args) {
		new ViewCompraAdm();
	}
	
	
}
