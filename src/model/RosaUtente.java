package model;

public class RosaUtente {

	private long id;
	private String nome;
	private int budget;
	private Utente utente;
	private Lega lega;
	private float punteggio;
	private float giornataPrec;
	private int golFatti;
	private int golSubiti;

	public RosaUtente() {
	}

	public RosaUtente(String nome, int budget, Utente utente, Lega lega, float punteggio, float giornataPrec, int pareggi,
			int sconfitte, int golFatti, int golSubiti) {
		this.nome = nome;
		this.budget = budget;
		this.utente = utente;
		this.lega = lega;
		this.punteggio = punteggio;
		this.giornataPrec = giornataPrec;
		this.golFatti = golFatti;
		this.golSubiti = golSubiti;
	}
	public RosaUtente(String nome,float punteggio,float giornataPrec,int pareggi,int sconfitte, int golFatti, int golSubiti) {
		this.nome = nome;
		this.budget=180;
		this.punteggio = punteggio;
		this.giornataPrec = giornataPrec;
		this.golFatti = golFatti;
		this.golSubiti = golSubiti;
	}
	public RosaUtente(String nome) {
		this.nome=nome;
		this.budget=180;
		this.punteggio=0;
		this.giornataPrec=0;
		this.golFatti = 0;
		this.golSubiti = 0;
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

	public float getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(float punteggio) {
		this.punteggio = punteggio;
	}

	public float getGiornataPrec() {
		return giornataPrec;
	}

	public void setGiornataPrec(float giornataPrec) {
		this.giornataPrec = giornataPrec;
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

	public String toString() {
		return nome;
	}

	

}
