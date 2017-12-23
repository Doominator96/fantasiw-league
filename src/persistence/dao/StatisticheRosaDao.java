package persistence.dao;

import java.util.List;

import model.StatisticheRosa;

public interface StatisticheRosaDao {
	public void save(StatisticheRosa statistiche);  // Create
	public StatisticheRosa findByPrimaryKey(int punteggio);     // Retrieve
	public List<StatisticheRosa> findAll();       
	public void update(StatisticheRosa statistiche); //Update
	public void delete(StatisticheRosa statistiche); //Delete	
}
