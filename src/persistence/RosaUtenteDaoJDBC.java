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
import model.RosaUtente;
import model.Utente;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;
import utility.GiocatoriComparator;
import utility.RoseComparator;

public class RosaUtenteDaoJDBC implements RosaUtenteDao {

	private DataSource dataSource;

	public RosaUtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(RosaUtente rosa) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			rosa.setId(id);
			String insert = "insert into rosa(id,nome,budget,utente,lega,punteggio,giornataPrec,golFatti,golSubiti) values (?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, rosa.getId());
			statement.setString(2, rosa.getNome());
			statement.setInt(3, rosa.getBudget());
			statement.setString(4, rosa.getUtente().getUserName());
			statement.setLong(5, rosa.getLega().getId());
			statement.setFloat(6, rosa.getPunteggio());
			statement.setFloat(7, rosa.getGiornataPrec());
			statement.setInt(8, rosa.getGolFatti());
			statement.setInt(9, rosa.getGolSubiti());
			statement.executeUpdate();

		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	/*
	 * versione con Join
	 */
	public List<Giocatore> findByPrimaryKeyJoin(Long id) {
		List<Giocatore> giocatori = new ArrayList<Giocatore>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from afferisce as a , giocatore as g where a.rosa=? AND g.id=a.giocatore";
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
	
	public List<Giocatore> findByPrimaryKeyFormazione(Long id) {
		List<Giocatore> giocatori = new ArrayList<Giocatore>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from formazione as f , giocatore as g where f.rosa=? AND g.id=f.giocatore";
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
	
	
	
	
	
	public List<Giocatore> findByPrimaryKeyJoinRuolo(Long id,String ruolo) {
		List<Giocatore> giocatori = new ArrayList<Giocatore>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from afferisce as a , giocatore as g where a.rosa=? AND g.id=a.giocatore AND g.ruolo=?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			statement.setString(2, ruolo);
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
		return giocatori;
	}

	/*
	 * versione con Lazy Load
	 */
	public RosaUtente findByPrimaryKey(Long id) {
		Connection connection = this.dataSource.getConnection();
		RosaUtente rosa = null;
		try {
			PreparedStatement statement;
			String query = "select * from rosa where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				rosa = new RosaUtente();
				rosa.setId(result.getLong("id"));
				rosa.setNome(result.getString("nome"));
				rosa.setBudget(result.getInt("budget"));
				rosa.setGolFatti(result.getInt("golFatti"));
				rosa.setGolSubiti(result.getInt("golSubiti"));
				rosa.setPunteggio(result.getFloat("punteggio"));
				rosa.setGiornataPrec(result.getFloat("giornataPrec"));
				Utente ut=new Utente(result.getString("utente"));
				rosa.setUtente(ut);
				Lega lg=new Lega();
				LegaDao ldao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
				lg=ldao.findByPrimaryKey(result.getLong("lega"));
				rosa.setLega(lg);
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
		return rosa;
	}
	public RosaUtente findByNome(String nome) {
		Connection connection = this.dataSource.getConnection();
		RosaUtente rosa = null;
		try {
			PreparedStatement statement;
			String query = "select * from rosa where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				rosa = new RosaUtente();
				rosa.setId(result.getLong("id"));
				rosa.setNome(result.getString("nome"));
				rosa.setBudget(result.getInt("budget"));
				rosa.setGolFatti(result.getInt("golFatti"));
				rosa.setGolSubiti(result.getInt("golSubiti"));
				rosa.setPunteggio(result.getFloat("punteggio"));
				rosa.setGiornataPrec(result.getFloat("giornataPrec"));
				Utente ut=new Utente(result.getString("utente"));
				rosa.setUtente(ut);
				Lega lg=new Lega();
				LegaDao ldao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
				lg=ldao.findByPrimaryKey(result.getLong("lega"));
				rosa.setLega(lg);
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
		return rosa;
	}
	
	public List<Lega> findByUtente(String user) {
		Connection connection = this.dataSource.getConnection();
		List<Lega> leghe = new LinkedList<>();
		try {
			//Lega lega;
			PreparedStatement statement;
			String query = "select * from lega as l , utente as u , rosa as r where u.username = r.utente AND u.username = ? AND r.lega=l.id";
			statement = connection.prepareStatement(query);
			statement.setString(1, user);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				LegaDao legaDao = new LegaDaoJDBC(dataSource);
				Lega lega = legaDao.findByPrimaryKey(result.getLong("lega"));
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

	public List<RosaUtente> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<RosaUtente> rose = new LinkedList<>();
		try {
			RosaUtente rosa1;
			PreparedStatement statement;
			String query = "select * from rosa";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				rosa1 = findByPrimaryKey(result.getLong("id"));
				rose.add(rosa1);
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
		return rose;
	}
	public void setPunteggio(long id,float punti,int golF,int golS) {
		Connection connection = this.dataSource.getConnection();
		try {
			String query ="Select * from rosa where id= ?";
			PreparedStatement statement1 = connection.prepareStatement(query);
			statement1.setLong(1, id);
			ResultSet result=statement1.executeQuery();
			result.next();
			punti+=result.getFloat("punteggio");
			golF+=result.getInt("golFatti");
			golS+=result.getInt("golSubiti");
			String update = "update rosa SET punteggio = ?,golFatti = ?, golSubiti = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setFloat(1, punti);
			statement.setInt(2, golF);
			statement.setInt(3, golS);
			statement.setLong(4, id);
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
	public void setCalcolato(long id,float giornataPrec) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update rosa SET giornataPrec = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setFloat(1, giornataPrec);
			statement.setLong(2, id);
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
	

	public List<RosaUtente> findAllUtente(String username) {
		Connection connection = this.dataSource.getConnection();
		List<RosaUtente> rose = new LinkedList<>();
		try {
			RosaUtente rosa1;
			PreparedStatement statement;
			String query = "select * from rosa where utente= ? ";
			statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				rosa1 = findByPrimaryKey(result.getLong("id"));
				rose.add(rosa1);
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
		return rose;
	}

	public List<RosaUtente> findAllLega(Long legaId) {
		Connection connection = this.dataSource.getConnection();
		List<RosaUtente> rose = new LinkedList<>();
		try {
			RosaUtente rosa1;
			PreparedStatement statement;
			String query = "select * from rosa where lega= ? ";
			statement = connection.prepareStatement(query);
			statement.setLong(1, legaId);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				rosa1 = findByPrimaryKey(result.getLong("id"));
				rose.add(rosa1);
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
		Collections.sort(rose,RoseComparator.COMPARATOR);
		Collections.reverse(rose);
		return rose;
	}
	
	public void update(RosaUtente rosa) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update rosa WHERE id= ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, rosa.getNome());

			// connection.setAutoCommit(false);
			// connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			statement.executeUpdate();
			// connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			}
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	public void delete(RosaUtente rosa) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM rosa WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, rosa.getId());

			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			statement.executeUpdate();
			connection.commit();
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
