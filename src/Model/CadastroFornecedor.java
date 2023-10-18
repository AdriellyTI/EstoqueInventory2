package Model;

public class CadastroFornecedor {

	private String nome;
	private String userName;
	private String cnpj;
	private String telefoneComercial;
	private String emailComercial;
	private String  telefoneRepresentante;
	private  String senha;
	
	
	
	public CadastroFornecedor(String nome, String userName, String cnpj, String telefoneComercial,
			String emailComercial, String telefoneRepresentante, String senha) {
		super();
		this.nome = nome;
		this.userName = userName;
		this.cnpj = cnpj;
		this.telefoneComercial = telefoneComercial;
		this.emailComercial = emailComercial;
		this.telefoneRepresentante = telefoneRepresentante;
		this.senha = senha;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getEmailComercial() {
		return emailComercial;
	}
	public void setEmailComercial(String emailComercial) {
		this.emailComercial = emailComercial;
	}
	public String getTelefoneRepresentante() {
		return telefoneRepresentante;
	}
	public void setTelefoneRepresentante(String telefoneRepresentante) {
		this.telefoneRepresentante = telefoneRepresentante;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}