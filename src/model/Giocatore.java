package model;

public class Giocatore {
	
	private long id;
	private String cognome;
	private String squadra;
	private String ruolo;
	private int costo;
	
	public Giocatore() {
	}
	
	public Giocatore(String cognome, String squadra, String ruolo, int costo) {
		this.cognome = cognome;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.costo = costo;
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
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String toString() {
		return cognome+" "+squadra+" "+ruolo+" "+costo;
	}
	

}
