package Model;

public class CadastroFornecedor {

	private int idFornecedor;
	private String nome;
	private String cnpj;
	private String telefoneComercial;
	private String emailComercial;
	private String  telefoneRepresentante;
	private String produtoForn;
	
	public CadastroFornecedor(){
		
	}
	
	public CadastroFornecedor(String nome, String cnpj, String telefoneComercial, String emailComercial,
			String telefoneRepresentante, String produtoForn) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefoneComercial = telefoneComercial;
		this.emailComercial = emailComercial;
		this.telefoneRepresentante = telefoneRepresentante;
		this.produtoForn = produtoForn;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public String getProdutoForn() {
		return produtoForn;
	}
	public void setProdutoForn(String produtoForn) {
		this.produtoForn = produtoForn;
	}
	
	
	
}