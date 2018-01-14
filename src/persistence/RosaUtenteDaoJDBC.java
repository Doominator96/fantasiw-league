package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Giocatore;
import model.RosaUtente;
import model.Utente;
import persistence.dao.GiocatoreDao;
import persistence.dao.RosaUtenteDao;


public class RosaUtenteDaoJDBC implements RosaUtenteDao{
	
	
	private DataSource dataSource;

	public RosaUtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(RosaUtente rosa) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			rosa.setId(id); 			
			String insert = "insert into rosa(id,nome,budget,utente,lega,punteggio,vittorie,pareggi,sconfitte,golFatti,golSubiti) values (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, rosa.getId());
			statement.setString(2, rosa.getNome());	
			statement.setInt(3, rosa.getBudget());
			statement.setString(4, rosa.getUtente().getUserName());
			statement.setLong(5, rosa.getLega().getId());
			statement.setInt(6, rosa.getPunteggio());
			statement.setInt(7, rosa.getVittorie());
			statement.setInt(8, rosa.getPareggi());
			statement.setInt(9, rosa.getSconfitte());
			statement.setInt(10, rosa.getGolFatti());
			statement.setInt(11, rosa.getGolSubiti());
			statement.executeUpdate();

		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
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
		List<Giocatore> giocatori=new ArrayList<Giocatore>();
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * FROM afferisce WHERE rosa = ?";
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
				rosa.setNome(result.getString("nome"));				
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
		}	 finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return rose;
	}

	public void update(RosaUtente rosa) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update rosa WHERE id= ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, rosa.getNome());

			//connection.setAutoCommit(false);
			//connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);			
			statement.executeUpdate();
			//connection.commit();
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
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

			/* 
			 * rimuoviamo i giocatori dal gruppo (ma non dal database) 
			 * potevano esserci soluzioni diverse (ad esempio rimuovere tutti i giocatori dal database
			 * (ma in questo caso non avrebbe senso)
			 * La scelta dipende dalla semantica delle operazioni di dominio
			 * 
			 * */
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
