package model;

import java.util.Set;

public class RosaUtente {
	
	private Set<Giocatore> giocatori;
	private String nome;
	private StatisticheRosa statistiche;
	private int budget;
	
	public RosaUtente(Set<Giocatore> giocatori, String nome, StatisticheRosa statistiche, int budget) {
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
	
	
	
	

}
