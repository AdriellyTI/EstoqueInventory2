package Model;

public class ModelProduto {

	
	private int id;
	private String nome;
	private double preco;
	private int quantidade;
	private int idForn;
	private String descrição;

	
	
	public ModelProduto(int id, String nome, double preco, int quantidade, int idForn, String descrição) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.idForn = idForn;
		this.descrição = descrição;
	}

	public ModelProduto() {
		
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getIdForn() {
		return idForn;
	}
	
	public void setIdForn(int idForn) {
		this.idForn = idForn;
	}
	
	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	
}
	