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
			String insert = "insert into statistiche(punteggio, vittorie, pareggi, sconfitte, golfatti, golsubiti) values (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setInt(1, statistiche.getPunteggio());
			statement.setInt(2, statistiche.getVittorie());
			statement.setInt(3, statistiche.getPareggi());
			statement.setInt(4, statistiche.getSconfitte());
			statement.setInt(5, statistiche.getGolFatti());
			statement.setInt(6, statistiche.getGolSubiti());

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

	public StatisticheRosa findByPrimaryKey(int punteggio) {
		Connection connection = this.dataSource.getConnection();
		StatisticheRosa statistiche = null;
		try {
			PreparedStatement statement;
			String query = "select * from statistiche where punteggio = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, punteggio);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				statistiche = new StatisticheRosa();
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
			String update = "update statistiche SET vittorie = ?, pareggi = ?, sconfitte = ?, golfatti = ?, golsubiti = ? WHERE punteggio=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setInt(1, statistiche.getPunteggio());
			statement.setInt(2, statistiche.getVittorie());
			statement.setInt(3, statistiche.getPareggi());
			statement.setInt(4, statistiche.getSconfitte());
			statement.setInt(5, statistiche.getGolFatti());
			statement.setInt(6, statistiche.getGolSubiti());
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
			String delete = "delete FROM statistiche WHERE punteggio = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setInt(1, statistiche.getPunteggio());
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
