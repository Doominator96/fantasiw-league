package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.StatisticheRosa;
import persistence.dao.StatisticheRosaDao;

public class StatisticheRosaDaoJDBC implements StatisticheRosaDao {
	private DataSource dataSource;

	public StatisticheRosaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(StatisticheRosa statistiche) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			statistiche.setId(id); 			
			String insert = "insert into statistiche(id,punteggio, vittorie, pareggi, sconfitte, golfatti, golsubiti) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, statistiche.getId());
			statement.setInt(2, statistiche.getPunteggio());
			statement.setInt(3, statistiche.getVittorie());
			statement.setInt(4, statistiche.getPareggi());
			statement.setInt(5, statistiche.getSconfitte());
			statement.setInt(6, statistiche.getGolFatti());
			statement.setInt(7, statistiche.getGolSubiti());

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

	public StatisticheRosa findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		StatisticheRosa statistiche = null;
		try {
			PreparedStatement statement;
			String query = "select * from statistiche where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				statistiche = new StatisticheRosa();
				statistiche.setId(result.getLong("id"));
				statistiche.setPunteggio(result.getInt("punteggio"));				
				statistiche.setVittorie(result.getInt("vittorie"));
				statistiche.setPareggi(result.getInt("pareggi"));
				statistiche.setSconfitte(result.getInt("sconfitte"));
				statistiche.setGolFatti(result.getInt("golfatti"));
				statistiche.setGolSubiti(result.getInt("golsubiti"));
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
		return statistiche;
	}

	public List<StatisticheRosa> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<StatisticheRosa> stats = new LinkedList<>();
		try {
			StatisticheRosa statistiche;
			PreparedStatement statement;
			String query = "select * from statistiche";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				statistiche = new StatisticheRosa();
				statistiche.setId(result.getLong("id"));
				statistiche.setPunteggio(result.getInt("punteggio"));				
				statistiche.setVittorie(result.getInt("vittorie"));
				statistiche.setPareggi(result.getInt("pareggi"));
				statistiche.setSconfitte(result.getInt("sconfitte"));
				statistiche.setGolFatti(result.getInt("golfatti"));
				statistiche.setGolSubiti(result.getInt("golsubiti"));
				
				stats.add(statistiche);
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
		return stats;
	}

	public void update(StatisticheRosa statistiche) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update statistiche SET id= ?, vittorie = ?, pareggi = ?, sconfitte = ?, golfatti = ?, golsubiti = ? WHERE punteggio=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, statistiche.getId());
			statement.setInt(2, statistiche.getPunteggio());
			statement.setInt(3, statistiche.getVittorie());
			statement.setInt(4, statistiche.getPareggi());
			statement.setInt(5, statistiche.getSconfitte());
			statement.setInt(6, statistiche.getGolFatti());
			statement.setInt(7, statistiche.getGolSubiti());
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

	public void delete(StatisticheRosa statistiche) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM statistiche WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, statistiche.getId());
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
