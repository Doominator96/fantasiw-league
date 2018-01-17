package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import persistence.dao.GiocatoreDao;

public class GiocatoreDaoJDBC implements GiocatoreDao{
	private DataSource dataSource;

	public GiocatoreDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Giocatore giocatore) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			giocatore.setId(id);
			String insert = "insert into giocatore(id,cognome, squadra, ruolo,costo) values (?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, giocatore.getId());
			statement.setString(2, giocatore.getCognome());
			statement.setString(3, giocatore.getSquadra());
			statement.setString(4, giocatore.getRuolo());
			statement.setInt(5,giocatore.getCosto());
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

	public Giocatore findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Giocatore giocatore = null;
		try {
			PreparedStatement statement;
			String query = "select * from giocatore where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				giocatore = new Giocatore();
				giocatore.setId(result.getLong("id"));
				giocatore.setCognome(result.getString("cognome"));
				giocatore.setSquadra(result.getString("squadra"));
				giocatore.setRuolo(result.getString("ruolo"));
				giocatore.setCosto(result.getInt("costo"));
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
		return giocatore;
	}

	public List<Giocatore> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Giocatore> giocatori = new LinkedList<>();
		try {
			Giocatore giocatore;
			PreparedStatement statement;
			String query = "select * from giocatore";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				giocatore = new Giocatore();
				giocatore.setId(result.getLong("id"));
				giocatore.setCognome(result.getString("cognome"));
				giocatore.setSquadra(result.getString("squadra"));
				giocatore.setRuolo(result.getString("ruolo"));
				giocatore.setCosto(result.getInt("costo"));
				
				giocatori.add(giocatore);
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
		return giocatori;
	}

	public void update(Giocatore giocatore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update giocatore SET cognome = ?, squadra = ?, ruolo = ?,costo = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, giocatore.getId());
			statement.setString(3, giocatore.getCognome());
			statement.setString(4, giocatore.getSquadra());
			statement.setString(5, giocatore.getRuolo());
			statement.setInt(5, giocatore.getCosto());
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

	public void delete(Giocatore giocatore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM giocatore WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, giocatore.getId());
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
