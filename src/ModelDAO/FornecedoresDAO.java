package ModelDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.CadastroFornecedor;

public class FornecedoresDAO {

	Connection connection;
	PreparedStatement statement ;
	 ResultSet rs;
		public FornecedoresDAO(Connection connection) {
			this.connection = connection;
		}
		
		public FornecedoresDAO () {
			
		}
	public void insertFornecedor(CadastroFornecedor usuarioAdm) throws SQLException {
		 
		 String url="INSERT INTO Fornecedoor(nomeEmpresa,cnpj,teleComercial,emailComercial,teleRepre,produtoForn) VALUES('"+usuarioAdm.getNome()+"','"+usuarioAdm.getCnpj()+"','"+usuarioAdm.getTelefoneComercial()+"','"+usuarioAdm.getEmailComercial()+"','"+usuarioAdm.getTelefoneRepresentante()+"','"+usuarioAdm.getProdutoForn()+"')";
			 
			 statement = connection.prepareStatement(url);
			 
			 statement.execute();
			 connection.close();
			 
		 }
	
	public List<CadastroFornecedor>preencheForn() {
	
		 List <CadastroFornecedor> listaAcesso = new ArrayList<CadastroFornecedor>();
		 
		 String url = "SELECT idFornecedor,nomeEmpresa,cnpj,teleComercial,emailComercial,teleRepre,produtoForn FROM Fornecedoor";
		 
			try {
				
	             Connection conn =new Conexao().getConnection();

				statement = conn.prepareStatement(url);
				rs=	statement.executeQuery();
		

			 while(rs.next()) {
				 
				
				 CadastroFornecedor p= new CadastroFornecedor();
				 
				 p.setIdFornecedor(rs.getInt("idFornecedor"));
				 p.setNome(rs.getString("nomeEmpresa"));
				 p.setCnpj(rs.getString("cnpj"));
				 p.setTelefoneComercial(rs.getString("teleComercial"));
				 p.setEmailComercial(rs.getString("emailComercial"));
				 p.setTelefoneRepresentante(rs.getString("teleRepre"));
				 p.setProdutoForn(rs.getString("produtoForn"));
				 
				 
				 listaAcesso.add(p);
			 }
			 }catch (Exception e) {
				 JOptionPane.showInternalMessageDialog(null, e);
				}
			 return listaAcesso;

	}
		
	}

