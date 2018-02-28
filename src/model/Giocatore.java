package model;

import java.util.HashMap;

public class Giocatore {

	private long id;
	private String cognome;
	private String squadra;
	private String ruolo;
	private int costo;
	private HashMap<String, Integer> statistiche;
	private double voto;

	public Giocatore(String _ruolo, int _costo) {
		
		ruolo = _ruolo;
		costo = _costo;
		statistiche = new HashMap<>();
		voto = 6.0;
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
		statistiche.put(gial, 0);

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
		return cognome + " " + squadra + " " + ruolo + " " + costo;
	}

	public HashMap<String, Integer> getStatistiche() {
		return statistiche;
	}

	public void setStatistiche(HashMap<String, Integer> statistiche) {
		this.statistiche = statistiche;
	}

	public double calcolaVoto() {

		if (ruolo != "PORTIERE") {
			for (int i = 0; i < 3; i++) {
				String key = calcolaGol();
				System.out.println("Esito Giocatore: "+ key);
				if (key != "Niente") {
					statistiche.put(key, statistiche.get(key) + 1);

					switch (key) {
					case "Gol":
						voto += 3;
						break;
					case "Rigore":
						voto += 2;
						break;
					case "Rigore Sbagliato":
						voto -= 3;
						break;
					}
				}
			}

			String yellow = calcolaGiallo();
			System.out.println("Esito Giallo: "+ yellow);
			statistiche.put(yellow, statistiche.get(yellow) + 1);
			if (yellow == "Giallo")
				voto -= 0.5;
		} else {
			String keyR = calcolaPortiereRigore();
			System.out.println("Esito Rigore Portiere: "+ keyR);

			statistiche.put(keyR, statistiche.get(keyR) + 1);
			switch (keyR) {
			case "Rigore Parato":
				voto += 3;
				break;
			case "Gol Subito":
				voto -= 1;
				break;
			}

			String keyT;

			for (int i = 0; i < 3; i++) {
				keyT = calcolaPortiereTiri();
				System.out.println("Esito Tiro Portiere: "+ keyT);
				statistiche.put(keyT, statistiche.get(keyT) + 1);

				switch (keyT) {
				case "Tiro Parato":
					voto += 0.5;
					break;
				case "Gol Subito":
					voto -= 1;
					break;
				}

			}

		}

		return voto;
	}

	public String calcolaGiallo() {
		double yellowCard = Math.random() * 100 + 1;

		if (yellowCard >= 0 && yellowCard <= 30)
			return "Giallo";

		return "Niente";
	}

	public String calcolaGol() {

		double probVal = 0;
		if (ruolo == "ATTACCANTE")
			probVal = 1.9;
		else if (ruolo == "CENTROCAMPISTA")
			probVal = 1.4;
		else if (ruolo == "DIFENSORE")
			probVal = 1.2;

		double probability = costo * probVal;
		double score = Math.random() * 100 + 1;

		if (score >= 1 && score <= probability) {
			double penaltyProb = Math.random() * 100 + 1;

			if (penaltyProb >= 0 && penaltyProb <= 20) {
				double penaltyScore = Math.random() * 100 + 1;
				if (penaltyScore >= 0 && penaltyScore <= 70) {
					return "Rigore"; // RIGORE SEGNATO
				} else {
					return "Rigore Sbagliato"; // RIGORE SBAGLIATO
				}
			}

			return "Gol"; // GOL SEGNATO

		}

		return "Niente";
	}

//	public String calcolaAssist() {
//		double probVal = 0;
//		if (ruolo == "CENTROCAMPISTA")
//			probVal = 2.8;
//		else if (ruolo == "DIFENSORE")
//			probVal = 2.8;
//
//		double probability = costo * probVal;
//		double assist = Math.random() * 100 + 1;
//
//		if (assist >= 0 && assist <= probability) {
//			return "Assist";
//		}
//	}

	public String calcolaPortiereRigore() {
		// Prova rigore
		double probRig = Math.random() * 100 + 1;
		if (probRig >= 60 && probRig <= 100) {
			double block = costo * 2.2;
			double rand = Math.random() * 100 + 1;

			if (rand >= 0 && rand <= block) { // PARA
				return "Rigore Parato";
			}
			return "Gol Subito"; // SUBISCE
		}
		return "Niente";
	}

	public String calcolaPortiereTiri() {

		double block = costo * 5;

		double rand = Math.random() * 100 + 1;
		if (rand >= 0 && rand <= block) {
			return "Tiro Parato";
		}

		return "Gol Subito";

	}
	
	public static void main(String[] args) {
		Giocatore g1 = new Giocatore("CENTROCAMPISTA",15);
		Giocatore g2 = new Giocatore("PORTIERE", 15);
		g1.calcolaVoto();
		g2.calcolaVoto();
		
		System.out.println(g1.voto);
		System.out.println(g2.voto);
	}

}
