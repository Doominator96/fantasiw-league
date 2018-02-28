package persistence.dao;

import java.util.List;

import model.Giocatore;
import model.Lega;
import model.RosaUtente;


public interface RosaUtenteDao {
	
	public void save(RosaUtente rosa);  // Create
	public RosaUtente findByPrimaryKey(Long id);     // Retrieve
	public RosaUtente findByNome(String nome);
	public List<Giocatore> findByPrimaryKeyJoin(Long id);
	public List<RosaUtente> findAll();
	public List<RosaUtente> findAllUtente(String username);
	public List<Lega> findByUtente(String user);
	public void update(RosaUtente rosa); //Update
	public void delete(RosaUtente rosa); //Delete	
	public List<RosaUtente> findAllLega(Long legaId); 
	public List<Giocatore> findByPrimaryKeyJoinRuolo(Long id,String ruolo);

}
