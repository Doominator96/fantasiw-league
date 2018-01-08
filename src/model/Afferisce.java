package model;

public class Afferisce {
	
	private int id;
	private Giocatore giocatore;
	private RosaUtente rosa;
	
	public Afferisce() {
	}
	
	public Afferisce(int id) {
		this.setId(id);
	}

	public static int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public static RosaUtente getRosa() {
		return rosa;
	}

	public void setRosa(RosaUtente rosa) {
		this.rosa = rosa;
	}


	
	

}
