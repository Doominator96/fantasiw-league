package model;

public class Giocatore {
	
	public enum Ruolo {
		ATTACCANTE,
		CENTROCAMPISTA,
		DIFENSORE,
		PORTIERE;
	}
	
	private String nome;
	private String cognome;
	private String squadra;
	private Ruolo ruolo;
	private int costo;
	
	public Giocatore() {
	}
	
	public Giocatore(String nome, String cognome, String squadra, Ruolo ruolo, int costo) {
		this.nome = nome;
		this.cognome = cognome;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.costo = costo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getSquadra() {
		return squadra;
	}
	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	
	

}
