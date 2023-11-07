package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import ModelDAO.Conexao;

public class CadastroFuncionario {

	private int idFuncionario;
	private String nome;
	private String userName;
	private String dataNasc;
	private String telefone;
	private String email;
	private String senha;
	
	public CadastroFuncionario() {
		
	}
	Connection conn;
	 
	 PreparedStatement stm ;
	 ResultSet rs;
	 
	 public CadastroFuncionario(Connection conn) {
		this.conn=conn;
	}
	 	
	
	public CadastroFuncionario(String nome, String userName, String dataNasc, String telefone, String email,
			String senha) {
		super();
		this.nome = nome;
		this.userName = userName;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}
	
	public int getIdFuncionario() {
		return idFuncionario;
	}


	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public void MostrarDadosUser(JLabel lblFotoUser,JLabel lblNomeUserRet,JLabel lblNomeCompletoRet,JLabel lblEmailUserRet,JLabel teleRet) {
		 String url = "SELECT *FROM Funcionario";
	     try { 
	    	 conn=new Conexao().getConnection();
	    	 stm = conn.prepareStatement(url);
	    	 rs=stm.executeQuery();
	    	 
	  		if (rs.next()) {
	  		
	          Blob  blob=(Blob) rs.getBlob("foto");
	          
	          byte[] img=blob.getBytes(1, (int) blob.length());
	          BufferedImage  image=null;
	          
	          try {
	          image=ImageIO.read(new ByteArrayInputStream(img));
	          
	          } catch (Exception e) {
	        	  System.out.println(e);
			}
	          ImageIcon icone= new ImageIcon(image);
	          Icon foto= new ImageIcon(icone.getImage().getScaledInstance(lblFotoUser.getWidth(), lblFotoUser.getHeight(), Image.SCALE_SMOOTH));
	          lblFotoUser.setIcon(foto);
	          
	          lblNomeUserRet.setText(rs.getString("userName"));
	          lblNomeCompletoRet.setText(rs.getString("nomeCompleto"));
	          lblEmailUserRet.setText(rs.getString("email"));
	          teleRet.setText(rs.getString("tele"));
	  		}else {
				 JOptionPane.showInternalMessageDialog(null, "Produto não cadastrado");
	             conn.close();
	  		}
	    	  
	    	 
	     }catch (Exception ex) {
	    	 System.out.println(ex);
	     }
		
	}
	
}
	
	