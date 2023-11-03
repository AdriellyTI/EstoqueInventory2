package Model;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;

import ModelDAO.Conexao;

public class ModelProduto {

	
	private int id;
	private String nome;
	private double preco;
	private double precoVenda;
	private int quantidade;
	private String nomeForn;
	private String descricao;
	Connection conn;
	 
	 PreparedStatement stm ;
	 ResultSet rs;
	 
	 public ModelProduto(Connection conn) {
		this.conn=conn;
	}
	 
	
	public ModelProduto(int id, String nome, double preco, int quantidade, String nomeForn, String descrição) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.nomeForn = nomeForn;
		this.descricao = descrição;
	}

	public ModelProduto() {
		
	}
	
	public ModelProduto(String nome, double preco, double precoVenda, int quantidade, String nomeForn,
			String descricao) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.precoVenda = precoVenda;
		this.quantidade = quantidade;
		this.nomeForn = nomeForn;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	public String getNomeForn() {
		return nomeForn;
	}

	public void setNomeForn(String nomeForn) {
		this.nomeForn = nomeForn;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descrição) {
		this.descricao = descrição;
	}
	
//	public void listar(JList listNomePr,JTextField txtNome) {
//			
//		String url = "SELECT *FROM produtos WHERE nome =?";
//	    try { 
//	   	 conn=new Conexao().getConnection();
//	   	 stm = conn.prepareStatement(url);
//	   	 stm.setString(1,txtNome.getText());
//	   	 rs=stm.executeQuery();
//	   	 while(rs.next()) {
//	   		 String linha=(String) listNomePr.getSelectedValue();
//	   		 txtNome.setText(linha);
//	   		 
//	 		}
//		catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public void BuscarPorNome(JList<String> listNomePr,JScrollPane  srcProdutos,JTextField txtNome) {
		DefaultListModel<String>  modelo = new DefaultListModel<>();
	     
    	listNomePr.setModel(modelo);
		listNomePr.setFont(new Font("Arial",Font.LAYOUT_NO_LIMIT_CONTEXT,20));
		 String url = "SELECT nome FROM produtos WHERE nome like '"+txtNome.getText()+"%'"+"order by nome";

		 try { 
		   	 conn=new Conexao().getConnection();
		   	 stm = conn.prepareStatement(url);
		   	 rs=stm.executeQuery();
		   	 
		 	 while(rs.next()) {
		 		 
		 		 if (txtNome.getText().length()==0) {
		 			 srcProdutos.setVisible(false);
		 		 }
		 			srcProdutos.setVisible(true);
		 			modelo.addElement(rs.getString("nome"));
		 		}
		 	 conn.close();
		 }catch (Exception ex) {
		   	 System.out.println(ex);
		 }
		 }
		 			
	public void BuscarProduto2(JTextField txtId,JTextField txtNome,JTextField txtPreco,JTextField txtNomeFornecedor,JTextField txtQuantEsto,JTextField txtDescricao,JLabel lblFoto) {
		
		 String url = "SELECT *FROM produtos WHERE nome =?";
    try { 
   	 conn=new Conexao().getConnection();
   	 stm = conn.prepareStatement(url);
   	 stm.setString(1,txtNome.getText());
   	 rs=stm.executeQuery();
   	 
 		if (rs.next()) {
          txtId.setText(rs.getString("id"));
          txtNomeFornecedor.setText(rs.getString("nome_fornecedor"));
		  txtPreco.setText(rs.getString("preco_venda"));
		  txtQuantEsto.setText(rs.getString("quantidade"));
         txtDescricao.setText(rs.getString("descricao"));
         Blob  blob=(Blob) rs.getBlob("foto");
         
         byte[] img=blob.getBytes(1, (int) blob.length());
         BufferedImage  image=null;
         
         try {
         image=ImageIO.read(new ByteArrayInputStream(img));
         
         } catch (Exception e) {
       	  System.out.println(e);
		}
         ImageIcon icone= new ImageIcon(image);
         Icon foto= new ImageIcon(icone.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH));
         lblFoto.setIcon(foto);
         
 		}else {
			 JOptionPane.showInternalMessageDialog(null, "Produto não cadastrado");
            conn.close();
 		}
   	  
   	  
    }catch (Exception ex) {
   	 System.out.println(ex);
    }
	}
	 

}
	