package Model;

public class ModelPagamentos {

    private int codigo;
	private String nomeCliente;
	private String dataVenda;
	private int numeroPecas;
	private double valorTotal;
	private String formaPagamento;

	public ModelPagamentos() {
		
	}
			

	public ModelPagamentos(String dataVenda,String nomeCliente, int numeroPecas, double valorTotal,
			String formaPagamento) {
		super();
		this.nomeCliente = nomeCliente;
		this.dataVenda = dataVenda;
		this.numeroPecas = numeroPecas;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		
	}
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public int getNumeroPecas() {
		return numeroPecas;
	}
	public void setNumeroPecas(int numeroPecas) {
		this.numeroPecas = numeroPecas;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	

}
