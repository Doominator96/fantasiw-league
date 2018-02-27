package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UtilDao {

	private DataSource dataSource;
	
	public UtilDao(DataSource dataSource) {
		this.dataSource=dataSource;
	}

public void dropDatabase(){
	
	Connection connection = dataSource.getConnection();
	try {
		String delete = "drop SEQUENCE if EXISTS sequenza_id;"
				+ "drop table if exists formazione;"
				+ "drop table if exists afferisce;"
				+ "drop table if exists rosa;"
				+ "drop table if exists lega;"
				+ "drop table if exists utente;"
				+ "drop table if exists giocatore;";
		PreparedStatement statement = connection.prepareStatement(delete);
		
		statement.executeUpdate();
		System.out.println("Executed drop database");
		
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

public void createDatabase(){
	
	Connection connection = dataSource.getConnection();
	try {
		
		String create = "create SEQUENCE sequenza_id;"
				+ "create table utente(\"username\" varchar(255) primary key,email varchar(255),password varchar(255));"
				+ "create table lega(\"id\" bigint primary key,nome varchar(255),password varchar(255));"
				+ "create table rosa (\"id\" bigint primary key, nome varchar(255),budget int, utente varchar(255) REFERENCES utente(\"username\"),lega bigint REFERENCES lega(\"id\"),punteggio int,vittorie int,pareggi int,sconfitte int,golFatti int,golSubiti int);"
				+ "create table giocatore(\"id\" bigint primary key,cognome varchar(255),squadra varchar(255),ruolo varchar(255),costo int);"
				+ "create table afferisce(\"id\" bigint primary key,giocatore bigint REFERENCES giocatore(\"id\"),rosa bigint REFERENCES rosa(\"id\"));"
				+ "create table formazione(\"id\" bigint primary key,giocatore bigint REFERENCES giocatore(\"id\"),rosa bigint REFERENCES rosa(\"id\"));";
		
		PreparedStatement statement = connection.prepareStatement(create);
		
		statement.executeUpdate();
		System.out.println("Executed create database");
		
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


public  void resetDatabase() {
		
		Connection connection = dataSource.getConnection();
		try {
			String delete = "delete FROM rosa";
			PreparedStatement statement = connection.prepareStatement(delete);
			
			statement.executeUpdate();

			delete = "delete FROM utente";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM giocatore";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM afferisce";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM formazione";
			statement = connection.prepareStatement(delete);
			
			delete = "delete FROM lega";
			statement = connection.prepareStatement(delete);
			
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

