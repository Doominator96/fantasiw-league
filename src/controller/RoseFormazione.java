package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import model.Giocatore;
import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.dao.RosaUtenteDao;

public class RoseFormazione extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		RosaUtenteDao rdao = DatabaseManager.getInstance().getDaoFactory().getRosaUtenteDAO();
		String utenteLoggato = session.getAttribute("username").toString();
		List<RosaUtente> roseF = rdao.findAllUtente(utenteLoggato);
		req.setAttribute("roseF", roseF);

			RequestDispatcher dispacher = req.getRequestDispatcher("formazione2.jsp");
			dispacher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		RosaUtenteDao rdao = DatabaseManager.getInstance().getDaoFactory().getRosaUtenteDAO();
		String utenteLoggato = session.getAttribute("username").toString();
		List<RosaUtente> roseF = rdao.findAllUtente(utenteLoggato);
		req.setAttribute("roseF", roseF);

			RequestDispatcher dispacher = req.getRequestDispatcher("formazione2.jsp");
			dispacher.forward(req, resp);
	
	}
}
