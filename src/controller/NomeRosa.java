package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Lega;
import model.RosaUtente;
import persistence.DAOFactory;
import persistence.PostgresDAOFactory;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;

public class NomeRosa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		String nomeR = req.getParameter("nome");
		RosaUtente rosa = PostgresDAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getRosaUtenteDAO().findByNome(nomeR);
		RosaUtenteDao rosaDao = PostgresDAOFactory.getInstance().getRosaUtenteDAO();

		if (rosa != null) {

		}
	}
}
