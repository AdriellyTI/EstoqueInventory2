package Model;

public class ModelFornecimento {

	private int codigo;
	private String dataFornec; 
	private int quantide;
	private String idProduto;
	private String nomeFornecedor;
	

	public ModelFornecimento(String dataFornec, int quantide, String idProduto) {
		super();
		this.dataFornec = dataFornec;
		this.quantide = quantide;
		this.idProduto = idProduto;
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
	public int getQuantide() {
		return quantide;
	}
	public void setQuantide(int quantide) {
		this.quantide = quantide;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	
}
