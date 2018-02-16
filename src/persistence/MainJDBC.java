package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Afferisce;
import model.Giocatore;
import model.Lega;
import model.RosaUtente;
import model.Utente;
import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;
import persistence.dao.UtenteDao;
public class MainJDBC {

	public static void main(String args[]) throws FileNotFoundException {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.POSTGRESQL);
		UtilDao util = factory.getUtilDAO();
		util.dropDatabase();

		util.createDatabase();

		File csvFile = new File("giocatori.csv");
		GiocatoreDao giocatoreDao = factory.getGiocatoreDAO();
		UtenteDao utenteDao = factory.getUtenteDAO();
		RosaUtenteDao rosaUtenteDao = factory.getRosaUtenteDAO();
		AfferisceDao afferisceDao = factory.getAfferisceDAO();
		LegaDao legaDao=factory.getLegaDAO();
		
		
		Utente utente1 = new Utente("jason", "porchettino@gmail.com", "puttana");
		Utente utente2 = new Utente("1", "1", "1");
		Lega lega1 = new Lega("Lega Nord","password");
		Lega lega2 = new Lega("Lega2","12345");
		Lega lega3 = new Lega("Serie C++","strtok");
		Lega lega4 = new Lega("Serie TV","facv");
	
			Scanner csvScanner = new Scanner(csvFile);
			while (csvScanner.hasNext()) {
				String nextLine = csvScanner.nextLine();
				String[] giocatore = nextLine.split(",");
				giocatoreDao.save(new Giocatore(giocatore[0], giocatore[1], giocatore[2], Integer.parseInt(giocatore[3])));
			}
			csvScanner.close();
			
		Giocatore giocatore1 = new Giocatore("Polacchini", "PopilBianco A.C.", "ATTACCANTE", 155);
		Giocatore giocatore2 = new Giocatore("Spino", "Saracena A.S.", "PORTIERE", 420);
		Giocatore giocatore3 = new Giocatore("Pier", "Sesso A.C", "CENTROCAMPISTA", 0);
		Giocatore giocatore4 = new Giocatore("Cavallo","SanBasil A.C.", "DIFENSORE", 25);
	
		RosaUtente rosa1 = new RosaUtente("Saporino A.C.",100,3,2,1,13,2);
		RosaUtente rosa2 = new RosaUtente("Farmacisti",100,6,1,3,17,9);
		RosaUtente rosa3 = new RosaUtente("Pischelletti",25,3,1,2,53,1);
		RosaUtente rosa4 = new RosaUtente("qdwca",23,6,2,5,13,2);
		RosaUtente rosa5 = new RosaUtente("csawd",421,7,6,3,17,9);
		RosaUtente rosa6 = new RosaUtente("dvvv",23,1,1,8,53,1);
		RosaUtente rosa7 = new RosaUtente("Yasx",42,9,2,6,13,2);
		RosaUtente rosa8 = new RosaUtente("Erik",130,14,5,3,17,9);
		RosaUtente rosa9 = new RosaUtente("Fornillo",535,25,1,2,53,1);
		RosaUtente rosa10 = new RosaUtente("Maesc",24,23,8,1,13,2);
		RosaUtente rosa11 = new RosaUtente("fggg",53,252,7,3,17,9);
		RosaUtente rosa12 = new RosaUtente("vczz",242,23,2,2,53,1);
		RosaUtente rosa13 = new RosaUtente("bbfbd",40,53,3,1,13,2);
		RosaUtente rosa14 = new RosaUtente("jyjrjr",10,45,4,3,17,9);
		RosaUtente rosa15 = new RosaUtente("dqfqfqdq",42,76,5,2,53,1);
		Afferisce afferisce1 =new Afferisce();
		
	
		// CREATE
		utenteDao.save(utente1);
		utenteDao.save(utente2);
		giocatoreDao.save(giocatore1);
		giocatoreDao.save(giocatore2);
		giocatoreDao.save(giocatore3);
		giocatoreDao.save(giocatore4);		
		afferisce1.setRosa(rosa1);
		afferisce1.setGiocatore(giocatore1);
		rosa1.setUtente(utente1);
		rosa4.setUtente(utente1);
		rosa5.setUtente(utente1);
		rosa6.setUtente(utente1);
		rosa7.setUtente(utente1);
		rosa8.setUtente(utente1);
		rosa9.setUtente(utente1);
		rosa10.setUtente(utente1);
		rosa11.setUtente(utente1);
		rosa12.setUtente(utente1);
		rosa13.setUtente(utente1);
		rosa14.setUtente(utente1);
		rosa15.setUtente(utente1);
		
		rosa1.setLega(lega1);
		rosa4.setLega(lega1);
		rosa5.setLega(lega1);
		rosa6.setLega(lega2);
		rosa7.setLega(lega1);
		rosa8.setLega(lega2);
		rosa9.setLega(lega1);
		rosa10.setLega(lega3);
		rosa11.setLega(lega3);
		rosa12.setLega(lega3);
		rosa13.setLega(lega4);
		rosa14.setLega(lega4);
		rosa15.setLega(lega4);
		rosa2.setUtente(utente2);
		rosa2.setLega(lega1);
		rosa3.setUtente(utente1);
		rosa3.setLega(lega2);
		legaDao.save(lega1);
		legaDao.save(lega2);
		legaDao.save(lega3);
		legaDao.save(lega4);
		rosaUtenteDao.save(rosa1);
		rosaUtenteDao.save(rosa2);
		rosaUtenteDao.save(rosa3);
		rosaUtenteDao.save(rosa4);
		rosaUtenteDao.save(rosa5);
		rosaUtenteDao.save(rosa6);
		rosaUtenteDao.save(rosa7);
		rosaUtenteDao.save(rosa8);
		rosaUtenteDao.save(rosa9);
		rosaUtenteDao.save(rosa10);
		rosaUtenteDao.save(rosa11);
		rosaUtenteDao.save(rosa12);
		rosaUtenteDao.save(rosa13);
		rosaUtenteDao.save(rosa14);
		rosaUtenteDao.save(rosa15);
		
		afferisceDao.save(afferisce1);
//		System.out.println(afferisce1.getGiocatore());
//		// RETRIEVE
//		System.out.println("Retrieve all rosa");
//		for (RosaUtente r : rosaUtenteDao.findAll()) {
//			System.out.println(r.getNome()); // NB: non viene invocato il metodo getStudenti()
//			System.out.println(".-.-.-.");
//			System.out.println(".-.-.-.");
//
//		}
//
//		System.out.println("Retrieve all utenti");
//		for (Utente u : utenteDao.findAll()) {
//			System.out.println(u);
//		}
//
//		System.out.println("Retrieve all giocatori");
//		for (Giocatore g : giocatoreDao.findAll()) {
//			System.out.println(g);
//		}
////		System.out.println("Retrieve all rose");
////		for (RosaUtente r : rosaUtenteDao.findAll()) {
////			System.out.println(r);
////		}
//
//		System.out.println("Elenco Afferisce");
//		for (Afferisce a : afferisceDao.findAll()) {
//			System.out.println(a);
//		}
		
		//for(RosaUtente r : rosaUtenteDao.findAllLega(lega1.getId()))
		//	System.out.println(r);
		for(Lega l : legaDao.findByUtente(utente1.getUserName()))
			System.out.println(l.getNome());
		
//		for(Giocatore g : rosaUtenteDao.findByPrimaryKeyJoin(rosa1.getId()))
//			System.out.println(g);
	}

}
