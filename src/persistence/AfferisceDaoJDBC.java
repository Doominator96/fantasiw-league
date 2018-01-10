package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Afferisce;
import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.RosaUtenteDao;

public class AfferisceDaoJDBC implements AfferisceDao{
	private DataSource dataSource;

	public AfferisceDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Afferisce afferisce) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			afferisce.setId(id);
			String insert = "insert into afferisce(id) values (?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, afferisce.getId());
			//statement.setLong(2, afferisce.getGiocatore().getId());
			//statement.setLong(3, afferisce.getRosa().getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}  

	public Afferisce findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Afferisce afferisce = null;
		try {
			PreparedStatement statement;
			String query = "select * from Afferisce where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				afferisce = new Afferisce();
				afferisce.setId(result.getLong("id"));		
				GiocatoreDao giocatoreDao=new GiocatoreDaoJDBC(dataSource);
				afferisce.setGiocatore(giocatoreDao.findByPrimaryKey(result.getLong("giocatore")));
				RosaUtenteDao rosaUtenteDao =new RosaUtenteDaoJDBC(dataSource);
				afferisce.setRosa(rosaUtenteDao.findByPrimaryKey(result.getLong("rosa")));
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
		return afferisce;
	}

	public List<Afferisce> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Afferisce> afferiscono = new LinkedList<>();
		try {
			PreparedStatement statement;
			String query = "select * from afferisce";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Afferisce afferisce = new Afferisce();
				afferisce.setId(result.getLong("id"));
				GiocatoreDao giocatoreDao=new GiocatoreDaoJDBC(dataSource);
				//giocatoreDao.findByPrimaryKey(result.getLong("giocatore")); !per le chiavi esterne
				afferisce.setGiocatore(giocatoreDao.findByPrimaryKey(result.getLong("giocatore")));
				RosaUtenteDao rosaUtenteDao =new RosaUtenteDaoJDBC(dataSource);
				afferisce.setRosa(rosaUtenteDao.findByPrimaryKey(result.getLong("rosa")));

			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return afferiscono;
	}

	public void update(Afferisce afferisce) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update giocatore SET giocatore = ?, rosa = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, afferisce.getId());
			statement.setLong(2, afferisce.getGiocatore().getId());
			statement.setLong(3, afferisce.getRosa().getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	public void delete(Afferisce afferisce) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM afferisce WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, afferisce.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

}
