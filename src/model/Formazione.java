package model;

public class Formazione {

	private long id;
	private Giocatore giocatore;
	private RosaUtente rosa;
	
	public Formazione() {
	}
	
	public Formazione(Giocatore giocatore, RosaUtente rosa) {
		this.giocatore = giocatore;
		this.rosa = rosa;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
