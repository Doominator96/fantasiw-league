package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


import model.Formazione;
import persistence.dao.FormazioneDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.RosaUtenteDao;

public class FormazioneDaoJDBC implements FormazioneDao{
	private DataSource dataSource;

	public FormazioneDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void save(Formazione formazione) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection);
			formazione.setId(id);
			String insert = "insert into formazione(id,giocatore,rosa) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, formazione.getId());
			statement.setLong(2, formazione.getGiocatore().getId());
			statement.setLong(3, formazione.getRosa().getId());
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

	@Override
	public Formazione findByPrimaryKey(long id) {
		Connection connection = this.dataSource.getConnection();
		Formazione formazione = null;
		try {
			PreparedStatement statement;
			String query = "select * from Formazione where id = ?";
			statement = connection.prepareStatement(query);
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				formazione = new Formazione();
				formazione.setId(result.getLong("id"));		
				GiocatoreDao giocatoreDao=new GiocatoreDaoJDBC(dataSource);
				formazione.setGiocatore(giocatoreDao.findByPrimaryKey(result.getLong("giocatore")));
				RosaUtenteDao rosaUtenteDao =new RosaUtenteDaoJDBC(dataSource);
				formazione.setRosa(rosaUtenteDao.findByPrimaryKey(result.getLong("rosa")));
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
		return formazione;
	}

	@Override
	public List<Formazione> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Formazione> formazioni = new LinkedList<>();
		try {
			PreparedStatement statement;
			String query = "select * from formazione";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Formazione formazione = new Formazione();
				formazione.setId(result.getLong("id"));
				GiocatoreDao giocatoreDao=new GiocatoreDaoJDBC(dataSource);
				//giocatoreDao.findByPrimaryKey(result.getLong("giocatore")); !per le chiavi esterne
				formazione.setGiocatore(giocatoreDao.findByPrimaryKey(result.getLong("giocatore")));
				RosaUtenteDao rosaUtenteDao =new RosaUtenteDaoJDBC(dataSource);
				formazione.setRosa(rosaUtenteDao.findByPrimaryKey(result.getLong("rosa")));

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
		return formazioni;
	}

	@Override
	public void update(Formazione formazione) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update formazione SET giocatore = ?, rosa = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, formazione.getId());
			statement.setLong(2, formazione.getGiocatore().getId());
			statement.setLong(3, formazione.getRosa().getId());
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

	@Override
	public void delete(Formazione formazione) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM formazione WHERE id = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, formazione.getId());
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
	public void deleteFromRosa(Long rosa) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "delete FROM formazione WHERE rosa = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setLong(1, rosa);
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
