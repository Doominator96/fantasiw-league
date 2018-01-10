package persistence.dao;

import java.util.List;

import model.Lega;

public interface LegaDao {

	public void save(Lega lega);  // Create
	public Lega findByPrimaryKey(Long id);     // Retrieve
	public List<Lega> findAll();       
	public void update(Lega lega); //Update
	public void delete(Lega lega); //Delete	
	
}
