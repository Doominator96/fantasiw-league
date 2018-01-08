package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Afferisce;
import model.Giocatore;
import persistence.dao.GiocatoreDao;

public class AfferisceDaoJDBC implements AfferisceDao{
	private DataSource dataSource;

	public AfferisceDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Afferisce afferisce) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into Afferisce(id,giocatore, rosa) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, Afferisce.getId());
			statement.setLong(2, Afferisce.getGiocatore().getId());
			statement.setLong(3, Afferisce.getRosa().getId());
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
			String query = "select * from giocatore where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				giocatore = new Giocatore();
				giocatore.setNome(result.getString("nome"));				
				giocatore.setCognome(result.getString("cognome"));
				giocatore.setSquadra(result.getString("squadra"));
				//giocatore.setRuolo(result.getString("ruolo"));
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
				giocatore.setNome(result.getString("nome"));				
				giocatore.setCognome(result.getString("cognome"));
				giocatore.setSquadra(result.getString("squadra"));
				//giocatore.setRuolo(result.getString("ruolo"));
				
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
			String update = "update giocatore SET cognome = ?, squadra = ?, ruolo = ? WHERE nome=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, giocatore.getNome());
			statement.setString(2, giocatore.getCognome());
			statement.setString(3, giocatore.getSquadra());
			statement.setString(4, giocatore.getRuolo().toString());
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
			String delete = "delete FROM giocatore WHERE nome = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, giocatore.getNome());
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
