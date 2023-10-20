package Model;

public class ModelProduto {

	
	private int id;
	private String nome;
	private double preco;
	private int quantidade;
	private String nomeForn;
	private String descrição;

	
	
	
	public ModelProduto(int id, String nome, double preco, int quantidade, String nomeForn, String descrição) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.nomeForn = nomeForn;
		this.descrição = descrição;
	}
	
	

	public ModelProduto(String nome, double preco, int quantidade, String nomeForn, String descrição) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.nomeForn = nomeForn;
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
	
	
	public String getNomeForn() {
		return nomeForn;
	}

	public void setNomeForn(String nomeForn) {
		this.nomeForn = nomeForn;
	}

	public String getDescrição() {
		return descrição;
	}
	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	
}
	