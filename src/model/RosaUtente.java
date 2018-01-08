package model;

import java.util.HashSet;
import java.util.Set;

public class RosaUtente {
	
	private long id;
	private Set<Giocatore> giocatori;
	private String nome;
	private StatisticheRosa statistiche;
	private int budget;
	
	public RosaUtente() {
	}
	
	public RosaUtente(long id,Set<Giocatore> giocatori, String nome, StatisticheRosa statistiche, int budget) {
		this.id=id;
		this.giocatori = giocatori;
		this.nome = nome;
		this.statistiche = statistiche;
		this.budget = budget;
	}

	public Set<Giocatore> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(Set<Giocatore> giocatori) {
		this.giocatori = giocatori;
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
	
	public void addGiocatore(Giocatore giocatore){
		if (this.giocatori == null){
			this.giocatori = new HashSet<Giocatore>();
		}
		this.giocatori.add(giocatore);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	

}
