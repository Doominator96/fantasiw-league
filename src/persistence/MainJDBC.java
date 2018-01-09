package persistence;

import model.Afferisce;
import model.Giocatore;
import model.RosaUtente;
import model.StatisticheRosa;
import model.Utente;
import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.RosaUtenteDao;
import persistence.dao.StatisticheRosaDao;
import persistence.dao.UtenteDao;

public class MainJDBC {//ESERCIZIO (richiede Java8	
//	install Postgres https://www.postgresql.org/download/
//  scegliere utente: postgres -- password: postgres
//	
//	Lanciare PGADIMN oppure psql 
//	create database test;
//
//
//
//	- Vedere MainJDBC File.
//	- Testare i Dao Studente e Gruppo.
//	- Aggiungere l'entita' INDIRIZZO(codice, nome) per lo studente 
	//(uno studente ha un solo indirizzo)
//	- Aggiungere l'entita' CORSO(codice, nome), molti a molti con Studente.
	
	public static void main(String args[]) {
		

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();
		
		util.createDatabase();
		
		//crea studenti
		//crea gruppo
		//find studenti
		//find gruppo
		//delete gruppo/studenti
		
		GiocatoreDao giocatoreDao = factory.getGiocatoreDAO();
		UtenteDao utenteDao = factory.getUtenteDAO();
		RosaUtenteDao rosautenteDao = factory.getRosaUtenteDAO();
		StatisticheRosaDao statisticheDao = factory.getStatisticheRosaDAO();
		AfferisceDao afferisceDao =factory.getAfferisceDAO();
		Utente utente1 = new Utente("jason","porchettino@gmail.com","puttana");
		
		Giocatore giocatore1 = new Giocatore("Rino","Polacchini","PopilBianco A.C.", "ATTACCANTE", 155);
		Giocatore giocatore2 = new Giocatore("Spino","DiLeone","Saracena A.S.", "PORTIERE", 420);
		Giocatore giocatore3 = new Giocatore("Pier","Porn","Sesso A.C", "CENTROCAMPISTA", 0);
		Giocatore giocatore4 = new Giocatore("Cavallo","Si","SanBasil A.C.", "DIFENSORE", 25);
		

		RosaUtente rosa1 = new RosaUtente();
		//l'id del gruppo e' gestito tramite la classe IDBroker
		rosa1.setNome("Rosa1");
		
		utente1.setRosa(rosa1);
		
		

		//CREATE
		utenteDao.save(utente1);
		
		giocatoreDao.save(giocatore1);
		giocatoreDao.save(giocatore2);
		giocatoreDao.save(giocatore3);
		giocatoreDao.save(giocatore4);
		
		rosautenteDao.save(rosa1);
		
		afferisceDao.save(new Afferisce(giocatore1,rosa1));
		StatisticheRosa stats1 = new StatisticheRosa();
		rosa1.setStatistiche(stats1);
		statisticheDao.save(stats1);
		
		
		
//		//RETRIEVE
//		System.out.println("Retrieve all rosa");
//		for(RosaUtente r : rosautenteDao.findAll()) {
//			System.out.println(r.getNome());  // NB: non viene invocato il metodo getStudenti()
//			System.out.println(".-.-.-.");
//			r.addGiocatore(g3);
//			System.out.println(".-.-.-.");
//
//		}
//
//		System.out.println("Retrieve all gruppo: proxy all'opera");
//		for(Gruppo g : gruppoDao.findAll()) {
//			System.out.println(g);
//		}
//
////		gruppo1.addStudente(studente3);
////		gruppoDao.update(gruppo1);
//		
//		System.out.println("Retrieve all gruppo: proxy all'opera");
//		for(Gruppo g : gruppoDao.findAll()) {
//			System.out.println(g);
//		}
//		
//		System.out.println("Elenco studenti");
//		for(Studente s : studenteDao.findAll()) {
//			System.out.println(s);
//		}	
//		
//		System.out.println("Elenco Corsi");
//		for(Corso c : corsoDao.findAll()) {
//			System.out.println(c);
//		}	
//		
//		System.out.println("Elenco Corsi di Laurea");
//		for(CorsoDiLaurea cl : corsoDiLaureaDao.findAll()) {
//			System.out.println(cl);
//		}	
	}

}
