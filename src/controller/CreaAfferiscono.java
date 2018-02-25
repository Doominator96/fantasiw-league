package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Afferisce;
import model.Giocatore;
import model.RosaUtente;
import persistence.PostgresDAOFactory;
import persistence.dao.AfferisceDao;
import persistence.dao.GiocatoreDao;
import persistence.dao.RosaUtenteDao;
import persistence.dao.UtenteDao;

public class CreaAfferiscono extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String[] ids = req.getParameter("id").split(",");
		AfferisceDao afferisceDao = PostgresDAOFactory.getInstance().getAfferisceDAO();
		GiocatoreDao giocatoreDao = PostgresDAOFactory.getInstance().getGiocatoreDAO();
		RosaUtenteDao rosaUtenteDao = PostgresDAOFactory.getInstance().getRosaUtenteDAO();
		RosaUtente rs = rosaUtenteDao.findByPrimaryKey((long) session.getAttribute("rosaCorrente"));
		Giocatore giocatore = new Giocatore();
		for (int i = 0; i < ids.length; i++) {
			giocatore = giocatoreDao.findByPrimaryKey(Long.parseLong(ids[i]));
			Afferisce afferisce = new Afferisce(giocatore, rs);
			afferisceDao.save(afferisce);
		}

	}

}
