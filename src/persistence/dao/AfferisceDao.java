package persistence.dao;

import java.util.List;

import model.Afferisce;

public interface AfferisceDao {
	
	public void save(Afferisce afferisce);  // Create
	public Afferisce findByPrimaryKey(long id);     // Retrieve
	public List<Afferisce> findAll();       
	public void update(Afferisce afferisce); //Update
	public void delete(Afferisce afferisce); //Delete	

}
