package Model;

import java.awt.Image;
import java.io.FileInputStream;

public class CadastroAdm {
	
	private FileInputStream fis;
	private int tamanho;
	private String nome;
	private String userName;
	private String dataNasc;
	private String telefone;
	private String email;
	private String senha;


	public CadastroAdm(String nome, String userName, String dataNasc, String telefone, String email, String senha) {
		super();
		this.nome = nome;
		this.userName = userName;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

	
	

	public CadastroAdm(FileInputStream fis, int tamanho) {
		super();
		this.fis = fis;
		this.tamanho = tamanho;
	}




	public FileInputStream getFis() {
		return fis;
	}
	public void setFis(FileInputStream fis) {
		this.fis = fis;
	}
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}




	public CadastroAdm() {
		
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
	
	
}