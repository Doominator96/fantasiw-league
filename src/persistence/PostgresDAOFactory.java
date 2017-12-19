package persistence;



import persistence.dao....Dao;

class PostgresDAOFactory extends DAOFactory {

	
	
	private static  DataSource dataSource;
	

	// --------------------------------------------

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/fantasiw-league","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}

	
	// --------------------------------------------
	
	@Override
	public ...Dao get...DAO() {
		return new ...DaoJDBC(dataSource);
	}

	@Override
	public UtilDao getUtilDAO(){
		return new UtilDao(dataSource);
	}
}
