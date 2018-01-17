package persistence;


import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;
import persistence.dao.UtenteDao;

public abstract class DAOFactory {

	public static final int HSQLDB = 1;
	
	public static final int POSTGRESQL = 2;

	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case HSQLDB:
			return null;//new HsqldbDAOFactory();
		case POSTGRESQL:
			return new PostgresDAOFactory();
		default:
			return null;
		}
	}
	
	public abstract UtilDao getUtilDAO();
	
	public abstract UtenteDao getUtenteDAO();
	
	public abstract RosaUtenteDao getRosaUtenteDAO();
	
	public abstract GiocatoreDao getGiocatoreDAO();
	
	public abstract AfferisceDao getAfferisceDAO();

	public abstract LegaDao getLegaDAO();
	
}
