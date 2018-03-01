package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import model.Lega;
import model.Utente;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.UtenteDao;
import utility.GiocatoriComparator;

public class LegaDaoJDBC implements LegaDao {
	private DataSource dataSource;

	public LegaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(Lega lega) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			lega.setId(id);
			String insert = "insert into lega(id,nome,password,amministratore) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, lega.getId());
			statement.setString(2, lega.getNome());
			statement.setString(3, lega.getPassword());
			statement.setString(4, lega.getAmministratore().getUserName());

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

	public Lega findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		Lega lega = null;
		try {
			PreparedStatement statement;
			String query = "select * from lega where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				lega = new Lega();
				lega.setId(result.getLong("id"));
				lega.setNome(result.getString("nome"));
				lega.setPassword(result.getString("password"));
				UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
				Utente amministratore = utenteDao.findByPrimaryKey(result.getString("amministratore"));
				lega.setAmministratore(amministratore);
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
		return lega;
	}
	
	public Lega findByCredential(String nome,String password) {
		Connection connection = this.dataSource.getConnection();
		Lega lega = null;
		try {
			PreparedStatement statement;
			String query = "select * from lega where nome = ? AND password=?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			statement.setString(2,password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				lega = new Lega();
				lega.setId(result.getLong("id"));
				lega.setNome(result.getString("nome"));
				lega.setPassword(result.getString("password"));
				UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
				Utente amministratore = utenteDao.findByPrimaryKey(result.getString("amministratore"));
				lega.setAmministratore(amministratore);
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
		return lega;
	}
	

	public List<Lega> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Lega> leghe = new LinkedList<>();
		try {
			Lega lega;
			PreparedStatement statement;
			String query = "select * from lega";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				lega = new Lega();
				lega.setId(result.getLong("id"));
				lega.setNome(result.getString("nome"));
				lega.setPassword(result.getString("password"));
				UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
				Utente amministratore = utenteDao.findByPrimaryKey(result.getString("amministratore"));
				lega.setAmministratore(amministratore);

				leghe.add(lega);
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
		return leghe;
	}
	public List<Lega> findByUtente(String username) {
		Connection connection = this.dataSource.getConnection();
		List<Lega> leghe = new LinkedList<>();
		try {
			Lega lega;
			PreparedStatement statement;
			String query = "select * from lega as l , utente as u , rosa as r where u.username = r.utente AND u.username = ? AND r.lega=l.id";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				lega = new Lega();
				lega.setId(result.getLong("id"));
				lega.setNome(result.getString("nome"));
				lega.setPassword(result.getString("password"));
				UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
				Utente amministratore = utenteDao.findByPrimaryKey(result.getString("amministratore"));
				lega.setAmministratore(amministratore);
				
				leghe.add(lega);
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
		return leghe;
	}
	
	public List<Giocatore> findByPrimaryKeyLega(Long id) {
		List<Giocatore> giocatori = new ArrayList<Giocatore>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from lega as l, giocatore as g , afferisce as a, rosa as r where r.lega=l.id and l.id=? AND r.id=a.rosa and a.giocatore=g.id";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				GiocatoreDao giocatoreDao = new GiocatoreDaoJDBC(dataSource);
				Giocatore giocatore = giocatoreDao.findByPrimaryKey(result.getLong("giocatore"));
				giocatori.add(giocatore);
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
		Collections.sort(giocatori,GiocatoriComparator.COMPARATOR);
		Collections.reverse(giocatori);
		return giocatori;
	}
	
	public Lega findByNome(String nome) {
		Connection connection = this.dataSource.getConnection();
		Lega lega = null;
		try {
			PreparedStatement statement;
			String query = "select * from lega where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				lega = new Lega();
				lega.setId(result.getLong("id"));
				lega.setNome(result.getString("nome"));
				lega.setPassword(result.getString("password"));
				UtenteDao utenteDao = DatabaseManager.getInstance().getDaoFactory().getUtenteDAO();
				Utente amministratore = utenteDao.findByPrimaryKey(result.getString("amministratore"));
				lega.setAmministratore(amministratore);
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
		return lega;
	}
	

	public void update(Lega lega) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update lega SET nome = ?,password = ?,amministratore = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, lega.getId());
			statement.setString(2, lega.getNome());
			statement.setString(3, lega.getPassword());
			statement.setString(4, lega.getAmministratore().getUserName());
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

	public void delete(Lega lega) {
		Connection connection = this.dataSource.getConnection();
		String delete = "delete FROM lega WHERE id = ? ";
		try {
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, lega.getId());
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