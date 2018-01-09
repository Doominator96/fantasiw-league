package model;

public class RosaUtente {
	
	private long id;
	private String nome;
	private int budget;
	private Utente utente;
	private StatisticheRosa statistiche;
	private Lega lega;
	
	public RosaUtente() {
	}
	
	public RosaUtente(String nome, int budget, StatisticheRosa statistiche) {
		this.nome = nome;
		this.budget = budget;
		this.statistiche = statistiche;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public StatisticheRosa getStatistiche() {
		return statistiche;
	}

	public void setStatistiche(StatisticheRosa statistiche) {
		this.statistiche = statistiche;
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
	
	
	

}
