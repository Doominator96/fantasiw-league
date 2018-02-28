package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Formazione;
import model.Giocatore;
import model.RosaUtente;
import persistence.PostgresDAOFactory;
import persistence.dao.FormazioneDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.RosaUtenteDao;

public class CreaFormazione extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String[] ids = req.getParameter("id").split(",");
		FormazioneDao formazioneDao = PostgresDAOFactory.getInstance().getFormazioneDAO();
		GiocatoreDao giocatoreDao = PostgresDAOFactory.getInstance().getGiocatoreDAO();
		RosaUtenteDao rosaUtenteDao = PostgresDAOFactory.getInstance().getRosaUtenteDAO();
		RosaUtente rs = rosaUtenteDao.findByPrimaryKey((long) session.getAttribute("rosaCU"));
		Giocatore giocatore = new Giocatore();
		formazioneDao.deleteFromRosa((long) session.getAttribute("rosaCU"));
		for (int i = 0; i < ids.length; i++) {
			giocatore = giocatoreDao.findByPrimaryKey(Long.parseLong(ids[i]));
			Formazione formazione = new Formazione(giocatore, rs);
			formazioneDao.save(formazione);
		}

	}
}
