package model;

public class RosaUtente {
	
	private long id;
	private String nome;
	private int budget;
	private Utente utente;
	private Lega lega;
	private int punteggio;
	private int vittorie;
	private int pareggi;
	private int sconfitte;
	private int golFatti;
	private int golSubiti;
	
	public RosaUtente() {
	}
	

	public RosaUtente(String nome, int budget, Utente utente, Lega lega, int punteggio, int vittorie, int pareggi,
			int sconfitte, int golFatti, int golSubiti) {
		this.nome = nome;
		this.budget = budget;
		this.utente = utente;
		this.lega = lega;
		this.punteggio = punteggio;
		this.vittorie = vittorie;
		this.pareggi = pareggi;
		this.sconfitte = sconfitte;
		this.golFatti = golFatti;
		this.golSubiti = golSubiti;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Lega getLega() {
		return lega;
	}

	public void setLega(Lega lega) {
		this.lega = lega;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	public int getVittorie() {
		return vittorie;
	}

	public void setVittorie(int vittorie) {
		this.vittorie = vittorie;
	}

	public int getPareggi() {
		return pareggi;
	}

	public void setPareggi(int pareggi) {
		this.pareggi = pareggi;
	}

	public int getSconfitte() {
		return sconfitte;
	}

	public void setSconfitte(int sconfitte) {
		this.sconfitte = sconfitte;
	}

	public int getGolFatti() {
		return golFatti;
	}

	public void setGolFatti(int golFatti) {
		this.golFatti = golFatti;
	}

	public int getGolSubiti() {
		return golSubiti;
	}

	public void setGolSubiti(int golSubiti) {
		this.golSubiti = golSubiti;
	}

	
	

}
