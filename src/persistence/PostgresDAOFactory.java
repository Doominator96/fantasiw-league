package persistence;

import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;
import persistence.dao.StatisticheRosaDao;
import persistence.dao.UtenteDao;

class PostgresDAOFactory extends DAOFactory {

	private static DataSource dataSource;

	// --------------------------------------------

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource = new DataSource("jdbc:postgresql://localhost:5432/fantasiw-league", "postgres", "postgres");
		} catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
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
