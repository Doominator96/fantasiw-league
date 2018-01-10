package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Lega;
import persistence.dao.LegaDao;

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
			String insert = "insert into lega(id,nome,password) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setLong(1, lega.getId());
			statement.setString(2, lega.getNome());
			statement.setString(3, lega.getPassword());
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

	public void update(Lega lega) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update lega SET nome = ?,password = ? WHERE id=?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setLong(1, lega.getId());
			statement.setString(2, lega.getNome());
			statement.setString(3, lega.getPassword());
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