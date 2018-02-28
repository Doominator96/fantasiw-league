package persistence.dao;

import java.util.List;

import model.Lega;
import model.Utente;

public interface LegaDao {

	public void save(Lega lega);  // Create
	public Lega findByPrimaryKey(Long id);     // Retrieve
	public List<Lega> findAll();       
	public void update(Lega lega); //Update
	public void delete(Lega lega); //Delete	
	public List<Lega> findByUtente(String username);
	public Lega findByNome(String nome);
	public Lega findByCredential(String nome,String password);
}
