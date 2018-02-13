package persistence.dao;

import java.util.List;

import model.RosaUtente;


public interface RosaUtenteDao {
	
	public void save(RosaUtente rosa);  // Create
	public RosaUtente findByPrimaryKey(Long id);     // Retrieve
	public List<RosaUtente> findAll();
	public List<RosaUtente> findAllUtente(String username);
	public void update(RosaUtente rosa); //Update
	public void delete(RosaUtente rosa); //Delete	
	public List<RosaUtente> findAllLega(Long legaId); 
	
}
