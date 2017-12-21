package persistence.dao;

import java.util.List;

import model.RosaUtente;


public interface RosaUtenteDao {
	
	public void save(RosaUtente rosa);  // Create
	public RosaUtente findByPrimaryKey(String nome);     // Retrieve
	public List<RosaUtente> findAll();       
	public void update(RosaUtente rosa); //Update
	public void delete(RosaUtente rosa); //Delete	

}
