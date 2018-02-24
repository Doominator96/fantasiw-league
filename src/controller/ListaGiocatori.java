package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Giocatore;
import model.Lega;
import persistence.DatabaseManager;
import persistence.dao.GiocatoreDao;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;

public class ListaGiocatori extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		GiocatoreDao gdao = DatabaseManager.getInstance().getDaoFactory().getGiocatoreDAO();

		List<Giocatore> portieri=gdao.findAllRuolo("PORTIERE");
		List<Giocatore> difensori=gdao.findAllRuolo("DIFENSORE");
		List<Giocatore> centrocampisti=gdao.findAllRuolo("CENTROCAMPISTA");
		List<Giocatore> attaccanti=gdao.findAllRuolo("ATTACCANTE");

		req.setAttribute("portieri", portieri);
		req.setAttribute("difensori", difensori);
		req.setAttribute("centrocampisti", centrocampisti);
		req.setAttribute("attaccanti", attaccanti);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("rosa.jsp");
		dispacher.forward(req, resp);
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
