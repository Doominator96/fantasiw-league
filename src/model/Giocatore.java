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

	public Giocatore() {

		statistiche = new HashMap<>();
		String n = "Niente";
		String goal = "Gol";
		String rig = "Rigore";
		String rigS = "RigoreSbagliato";
		String ass = "Assist";
		String gial = "Giallo";
		String ros = "Rosso";

		String pRig = "RigoreParato";
		String pTir = "TiroParato";
		String pGol = "GolSubito";

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

	public double calcolaVotoHashMap() {
		voto=6.0;
		for (String key : statistiche.keySet()) {
			if (!key.equals("Niente")) {
				switch (key) {
				case "Gol":
					voto += 3*statistiche.get(key);
					break;
				case "Rigore":
					voto += 2*statistiche.get(key);
					break;
				case "RigoreSbagliato":
					voto -= 3*statistiche.get(key);
					break;
				case "RigoreParato":
					voto += 3*statistiche.get(key);
					break;
				case "GolSubito":
					voto -= 1*statistiche.get(key);
					break;
				case "Giallo":
					voto -=0.5*statistiche.get(key);
				case "TiroParato":
					voto +=0.5*statistiche.get(key);
				}
			}

		}
		return voto;
	}

	public double getVoto() {
		return voto;
	}

	public void setVoto(double voto) {
		this.voto = voto;
	}

	public void calcolaVoto() {
		if (!ruolo.equals("PORTIERE")) {
			for (int i = 0; i < 3; i++) {
				String key = calcolaGol();
				System.out.println("Esito Giocatore: " + key);
				if (!key.equals("Niente")) {
					statistiche.put(key, statistiche.get(key) + 1);

				}
			}

			String yellow = calcolaGiallo();
			System.out.println("Esito Giallo: " + yellow);
			statistiche.put(yellow, statistiche.get(yellow) + 1);
		} else {
			String keyR = calcolaPortiereRigore();
			System.out.println("Esito Rigore Portiere: " + keyR);

			statistiche.put(keyR, statistiche.get(keyR) + 1);
		

			String keyT;

			for (int i = 0; i < 3; i++) {
				keyT = calcolaPortiereTiri();
				System.out.println("Esito Tiro Portiere: " + keyT);
				statistiche.put(keyT, statistiche.get(keyT) + 1);


			}

		}

	}

	public String calcolaGiallo() {
		double yellowCard = Math.random() * 100 + 1;

		if (yellowCard >= 0 && yellowCard <= 30)
			return "Giallo";

		return "Niente";
	}

	public String calcolaGol() {
		double probVal = 0;
		if (ruolo.equals("ATTACCANTE")) {
			probVal = 1.9;
		} else if (ruolo.equals("CENTROCAMPISTA"))
			probVal = 1.4;
		else if (ruolo.equals("DIFENSORE"))
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
					return "RigoreSbagliato"; // RIGORE SBAGLIATO
				}
			}

			return "Gol"; // GOL SEGNATO

		}

		return "Niente";
	}

	// public String calcolaAssist() {
	// double probVal = 0;
	// if (ruolo == "CENTROCAMPISTA")
	// probVal = 2.8;
	// else if (ruolo == "DIFENSORE")
	// probVal = 2.8;
	//
	// double probability = costo * probVal;
	// double assist = Math.random() * 100 + 1;
	//
	// if (assist >= 0 && assist <= probability) {
	// return "Assist";
	// }
	// }

	public String calcolaPortiereRigore() {
		// Prova rigore
		double probRig = Math.random() * 100 + 1;
		if (probRig >= 60 && probRig <= 100) {
			double block = costo * 2.2;
			double rand = Math.random() * 100 + 1;

			if (rand >= 0 && rand <= block) { // PARA
				return "RigoreParato";
			}
			return "GolSubito"; // SUBISCE
		}
		return "Niente";
	}

	public String calcolaPortiereTiri() {

		double block = costo * 5;

		double rand = Math.random() * 100 + 1;
		if (rand >= 0 && rand <= block) {
			return "TiroParato";
		}

		return "GolSubito";

	}

}
