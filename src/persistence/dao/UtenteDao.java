package persistence.dao;

import java.util.List;

import model.Utente;
import persistence.UtenteCredenziali;

public interface UtenteDao {
	

	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(String username);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	
	
	public void setPassword(Utente utente, String password);
	public static  UtenteCredenziali findByPrimaryKeyCredential(String username) {
		// TODO Auto-generated method stub
		return null;
	}     // Retrieve
	public Utente findByCredential(String username, String password);

}
