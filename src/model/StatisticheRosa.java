package model;

public class StatisticheRosa {
	
	private int punteggio;
	private int vittorie;
	private int pareggi;
	private int sconfitte;
	private int golFatti;
	private int golSubiti;
	
	public StatisticheRosa(int punteggio, int vittorie, int pareggi, int sconfitte, int golFatti, int golSubiti) {
		this.punteggio = punteggio;
		this.vittorie = vittorie;
		this.pareggi = pareggi;
		this.sconfitte = sconfitte;
		this.golFatti = golFatti;
		this.golSubiti = golSubiti;
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
