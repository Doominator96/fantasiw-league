package model;

public class Afferisce {
	
	private long id;
	private Giocatore giocatore;
	private RosaUtente rosa;
	
	public Afferisce() {
	}

	
	public Afferisce(Giocatore giocatore, RosaUtente rosa) {
		this.giocatore = giocatore;
		this.rosa = rosa;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public RosaUtente getRosa() {
		return rosa;
	}

	public void setRosa(RosaUtente rosa) {
		this.rosa = rosa;
	}


	
	

}
