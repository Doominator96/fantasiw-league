package persistence.dao;

import java.util.List;

import model.Formazione;

public interface FormazioneDao {
	
	public void save(Formazione formazione);  // Create
	public Formazione findByPrimaryKey(long id);     // Retrieve
	public List<Formazione> findAll();       
	public void update(Formazione formazione); //Update
	public void delete(Formazione formazione); //Delete
	public void deleteFromRosa(Long rosa); //Delete
}
