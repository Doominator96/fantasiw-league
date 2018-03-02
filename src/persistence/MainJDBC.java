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
		
	
			Scanner csvScanner = new Scanner(csvFile);
			while (csvScanner.hasNext()) {
				String nextLine = csvScanner.nextLine();
				String[] giocatore = nextLine.split(",");
				giocatoreDao.save(new Giocatore(giocatore[0], giocatore[1], giocatore[2], Integer.parseInt(giocatore[3])));
			}
			csvScanner.close();

		
	}

}
