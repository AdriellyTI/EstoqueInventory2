package Model;

public class ModelFornecimento {

	private int codigo;
	private String dataFornec; 
	private int quantideForn;
	private int quantidadeEstoque;
	private String nomeProduto;
	private int idProduto;
	private String nomeFornecedor;
    private double precoProduto;

	
	public ModelFornecimento(String dataFornec, int quantideForn, int quantidadeEstoque, String nomeProduto,
			int idProduto, String nomeFornecedor, double precoProduto) {
		super();
		this.dataFornec = dataFornec;
		this.quantideForn = quantideForn;
		this.quantidadeEstoque = quantidadeEstoque;
		this.nomeProduto = nomeProduto;
		this.idProduto = idProduto;
		this.nomeFornecedor = nomeFornecedor;
		this.precoProduto = precoProduto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDataFornec() {
		return dataFornec;
	}
	public void setDataFornec(String dataFornec) {
		this.dataFornec = dataFornec;
	}
	
	public int getQuantideForn() {
		return quantideForn;
	}
	public void setQuantideForn(int quantideForn) {
		this.quantideForn = quantideForn;
	}
	
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	
	
}
