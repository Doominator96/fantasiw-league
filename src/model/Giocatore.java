package model;

import java.util.HashMap;

public class Giocatore {
	
	private long id;
	private String cognome;
	private String squadra;
	private String ruolo;
	private int costo;
	private HashMap<String, Integer> statistiche;
	
	public Giocatore() {
		statistiche = new HashMap<>();
		
		String n = "Niente";
		String goal = "Gol";
		String rig = "Rigore";
		String rigS = "Rigore Sbagliato";
		String ass = "Assist";
		String gial = "Giallo";
		String ros = "Rosso";
		
		String pRig = "Rigore Parato";
		String pTir = "Tiro Parato";
		String pGol = "Gol Subito";
		
		statistiche.put(n, 0);
		statistiche.put(goal, 0);
		statistiche.put(rig, 0);
		statistiche.put(rigS, 0);
		statistiche.put(ass, 0);
		
		statistiche.put(pRig, 0);
		statistiche.put(pTir, 0);
		statistiche.put(pGol, 0);
		
		
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

	public HashMap<String, Integer> getStatistiche() {
		return statistiche;
	}

	public void setStatistiche(HashMap<String, Integer> statistiche) {
		this.statistiche = statistiche;
	}
	
	
	

}
