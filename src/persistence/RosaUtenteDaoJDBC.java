package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.Corso;
import model.Giocatore;
import model.RosaUtente;
import model.Studente;
import model.Utente;
import persistence.dao.GiocatoreDao;
import persistence.dao.RosaUtenteDao;


public class RosaUtenteDaoJDBC implements RosaUtenteDao{
	
	
	private DataSource dataSource;

	public RosaUtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void save(RosaUtente rosa) {
		if ( (rosa.getGiocatori() == null) 
				|| rosa.getGiocatori().isEmpty()){
			throw new PersistenceException("Rosa non memorizzata: una rosa deve avere almeno un giocatore");
		}
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into rosa(nome) values (?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, rosa.getNome());
			

			//connection.setAutoCommit(false);
			//serve in caso i giocatori non siano stati salvati. Il DAO giocatore apre e chiude una transazione nuova.
			//connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);			
			statement.executeUpdate();
			// salviamo anche tutti i giocatori della rosa in CASACATA
			this.updateGiocatori(rosa, connection);
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

	private void updateGiocatori(RosaUtente rosa, Connection connection) throws SQLException {
		GiocatoreDao giocatoreDao = new GiocatoreDaoJDBC(dataSource);
		for (Giocatore giocatore : rosa.getGiocatori()) {
			if (giocatoreDao.findByPrimaryKey(giocatore.getNome()) == null){
				giocatoreDao.save(giocatore);
			}
			
			String inRosa = "select nome from inRosa where nome_giocatore=? AND rosa_nome=?";
			PreparedStatement statementInRosa = connection.prepareStatement(inRosa);
			statementInRosa.setString(1, giocatore.getNome());
			statementInRosa.setString(2, giocatore.getCognome());
			ResultSet result = statementInRosa.executeQuery();
			if(result.next()){
				String update = "update giocatore SET rosa_nome = ? WHERE nome = ?";
				PreparedStatement statement = connection.prepareStatement(update);
				statement.setString(1, rosa.getNome());
				statement.executeUpdate();
			}else{			
				String inserisci = "insert into inRosa(nome, cognome, squadra, ruolo, costo) values (?,?,?,?,?)";
				PreparedStatement statementInserisci = connection.prepareStatement(inserisci);
				statementInserisci.setString(1, giocatore.getNome());
				statementInserisci.setString(2, giocatore.getCognome());
				statementInserisci.setString(3, giocatore.getSquadra());
				statementInserisci.setString(4, giocatore.getRuolo());  
				statementInserisci.setInt(5, giocatore.getCosto());
				statementInserisci.executeUpdate();
			}
		}
	}
	
	private void removeForeignKeyFromGiocatore(RosaUtente rosa, Connection connection) throws SQLException {
		for (Giocatore giocatore : rosa.getGiocatori()) {
			String update = "update inRosa SET rosa_nome = NULL WHERE nome_giocatore = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, giocatore.getNome());
			statement.executeUpdate();
		}	
	}

	/* 
	 * versione con Join
	 */
	public RosaUtente findByPrimaryKeyJoin(String nome) {
		Connection connection = this.dataSource.getConnection();
		RosaUtente rosa = null;
		try {
			PreparedStatement statement;
			String query = "select r.nome as r_nome, g.nome as g_nome, "
					+ "g.cognome as g_cognome, g.squadra as g_squadra, g.ruolo as g_ruolo "
					+ "from rosa r, inRosa i, giocatore g "
					+ "where r.nome = ?"
					+ "			AND i.nome_giocatore = g.nome "
					+ "			AND i.rosa_nome = r.nome";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();
			boolean primaRiga = true;
			while (result.next()) {
				if (primaRiga) {
					rosa = new RosaUtente();
					rosa.setNome(result.getString("r_nome"));				
					primaRiga = false;
				}
				if(result.getString("g_nome")!=null){
					Giocatore giocatore = new Giocatore();
					giocatore.setNome(result.getString("g_nome"));
					giocatore.setCognome(result.getString("g_cognome"));
					giocatore.setSquadra(result.getString("g_squadra"));
					
					rosa.addGiocatore(giocatore);
				}
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



	/* 
	 * versione con Lazy Load
	 */
	public RosaUtente findByPrimaryKey(String nome) {
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

	public List<RosaUtente> findAll() {  //credo per vedere le rose degli altri utenti...dobbiamo decidere bene
		Connection connection = this.dataSource.getConnection();
		List<RosaUtente> rose = new ArrayList<>();
		try {		
			RosaUtente rosa;
			PreparedStatement statement;
			String query = "select * from rosa";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				rosa = findByPrimaryKeyJoin(result.getString("nome"));
				rose.add(rosa);
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
			String update = "update rosa WHERE nome = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, rosa.getNome());

			//connection.setAutoCommit(false);
			//connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);			
			statement.executeUpdate();
			this.updateGiocatori(rosa, connection); // se abbiamo deciso di propagare gli update seguendo il riferimento
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
			String delete = "delete FROM rosa WHERE nome = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, rosa.getNome());

			/* 
			 * rimuoviamo i giocatori dal gruppo (ma non dal database) 
			 * potevano esserci soluzioni diverse (ad esempio rimuovere tutti i giocatori dal database
			 * (ma in questo caso non avrebbe senso)
			 * La scelta dipende dalla semantica delle operazioni di dominio
			 * 
			 * */
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);			
			this.removeForeignKeyFromGiocatore(rosa, connection);     			
			/* 
			 * ora rimuoviamo il gruppo
			 * 
			 * */
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
