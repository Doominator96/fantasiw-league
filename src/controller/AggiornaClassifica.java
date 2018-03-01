package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.dao.RosaUtenteDao;

public class AggiornaClassifica extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		float punti=Float.parseFloat(req.getParameter("punti"));
		int golF=Integer.parseInt(req.getParameter("golF"));
		int golS=Integer.parseInt(req.getParameter("golS"));
		System.out.println(punti);
		System.out.println(req.getParameter("rose1").toString());
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
		rdao.setPunteggio(Long.parseLong(req.getParameter("rose1")), punti, golF, golS);
	}

}
