package model;

public class Lega {
	
	private long id;
	private String nome;
	private String password;
	
	public Lega() {
	}

	public Lega(String nome, String password) {
		this.nome = nome;
		this.password=password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}