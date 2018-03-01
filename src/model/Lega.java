package model;

import java.util.HashMap;

public class Lega {
	
	private long id;
	private String nome;
	private String password;
	private Utente amministratore;
	private HashMap<Long, HashMap<String,Integer>> voti;
	
	public Lega() {
		voti=new HashMap<>();
	}

	public Lega(String nome, String password,Utente amministratore) {
		this.nome = nome;
		this.password=password;
		this.amministratore=amministratore;
	}

	public Lega(long id, String nome, String password) {
		this.id=id;
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

	public Utente getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Utente amministratore) {
		this.amministratore = amministratore;
	}
	
	public void add(HashMap<String, Integer> voto, Long id)
	{
		voti.put(id, voto);
	}
	public HashMap<String,Integer> getStats(Long id){
		return voti.get(id);
		
	}
}

