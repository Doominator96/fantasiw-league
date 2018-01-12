package persistence;

import model.Afferisce;
import model.Giocatore;
import model.Lega;
import model.RosaUtente;
import model.StatisticheRosa;
import model.Utente;
import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;
import persistence.dao.StatisticheRosaDao;
import persistence.dao.UtenteDao;

public class MainJDBC {

	public static void main(String args[]) {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();

		util.createDatabase();

		GiocatoreDao giocatoreDao = factory.getGiocatoreDAO();
		UtenteDao utenteDao = factory.getUtenteDAO();
		RosaUtenteDao rosaUtenteDao = factory.getRosaUtenteDAO();
		AfferisceDao afferisceDao = factory.getAfferisceDAO();
		LegaDao legaDao=factory.getLegaDAO();
		
		
		Utente utente1 = new Utente("jason", "porchettino@gmail.com", "puttana");
		Lega lega1 = new Lega("PiùGhiusto","password");
		Giocatore giocatore1 = new Giocatore("Rino", "Polacchini", "PopilBianco A.C.", "ATTACCANTE", 155);
		Giocatore giocatore2 = new Giocatore("Spino", "DiLeone", "Saracena A.S.", "PORTIERE", 420);
		Giocatore giocatore3 = new Giocatore("Pier", "Porn", "Sesso A.C", "CENTROCAMPISTA", 0);
		Giocatore giocatore4 = new Giocatore("Cavallo", "Si", "SanBasil A.C.", "DIFENSORE", 25);
		RosaUtente rosa1 = new RosaUtente();
		Afferisce afferisce1 =new Afferisce();
		
		
		rosa1.setNome("Rosa1");
		// CREATE
		utenteDao.save(utente1);
		giocatoreDao.save(giocatore1);
		giocatoreDao.save(giocatore2);
		giocatoreDao.save(giocatore3);
		giocatoreDao.save(giocatore4);		
		afferisce1.setRosa(rosa1);
		afferisce1.setGiocatore(giocatore1);
		rosa1.setUtente(utente1);
		rosa1.setLega(lega1);
		legaDao.save(lega1);
		rosaUtenteDao.save(rosa1);
		
		
		afferisceDao.save(afferisce1);
		System.out.println(afferisce1.getGiocatore());
		// RETRIEVE
		System.out.println("Retrieve all rosa");
		for (RosaUtente r : rosaUtenteDao.findAll()) {
			System.out.println(r.getNome()); // NB: non viene invocato il metodo getStudenti()
			System.out.println(".-.-.-.");
			System.out.println(".-.-.-.");

		}

		System.out.println("Retrieve all utenti");
		for (Utente u : utenteDao.findAll()) {
			System.out.println(u);
		}

		System.out.println("Retrieve all giocatori");
		for (Giocatore g : giocatoreDao.findAll()) {
			System.out.println(g);
		}
//		System.out.println("Retrieve all rose");
//		for (RosaUtente r : rosaUtenteDao.findAll()) {
//			System.out.println(r);
//		}

		System.out.println("Elenco Afferisce");
		for (Afferisce a : afferisceDao.findAll()) {
			System.out.println(a);
		}
	}

}
