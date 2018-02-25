package persistence;

import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;
import persistence.dao.UtenteDao;

public class PostgresDAOFactory extends DAOFactory {

	private static DataSource dataSource;
	private static PostgresDAOFactory factory;

	// --------------------------------------------

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//remoto
			dataSource = new DataSource("jdbc:postgresql://horton.elephantsql.com:5432/myjavqql", "myjavqql", "PCrwqbrY66vkT7iUUS2wsCcv98X8v-2y");
//			//locale
//			dataSource=new DataSource("jdbc:postgresql://localhost:5432/CryptoBet","postgres","postgres");
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}
	

	public static PostgresDAOFactory getInstance(){
		if (factory == null){
			factory = new PostgresDAOFactory();
		}
		return factory;
	}
	// --------------------------------------------

	@Override
	public AfferisceDao getAfferisceDAO() {
		return new AfferisceDaoJDBC(dataSource);
	}

	@Override
	public UtilDao getUtilDAO() {
		return new UtilDao(dataSource);
	}

	@Override
	public UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}

	@Override
	public RosaUtenteDao getRosaUtenteDAO() {
		return new RosaUtenteDaoJDBC(dataSource);
	}

	@Override
	public GiocatoreDao getGiocatoreDAO() {
		return new GiocatoreDaoJDBC(dataSource);
	}

	@Override
	public LegaDao getLegaDAO() {
		return new LegaDaoJDBC(dataSource);
	}

}
