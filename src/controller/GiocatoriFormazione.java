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
import persistence.DatabaseManager;
import persistence.dao.RosaUtenteDao;

public class GiocatoriFormazione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long selectedRosa=0;
		HttpSession session = req.getSession();
		if(req.getParameter("rosaU")!=null)
		{
		   selectedRosa=Long.parseLong(req.getParameter("rosaU"));
		}
		System.out.println(selectedRosa);
		session.setAttribute("rosaCU", selectedRosa);     
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
		List<Giocatore> portieri = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"PORTIERE");
		List<Giocatore> difensori = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"DIFENSORE");
		List<Giocatore> centrocampisti = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"CENTROCAMPISTA");
		List<Giocatore> attaccanti = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"ATTACCANTE");
		
			
			req.setAttribute("por", portieri);

			req.setAttribute("dif", difensori);

			req.setAttribute("cen", centrocampisti);

			req.setAttribute("att", attaccanti);
			
			RequestDispatcher dispacher = req.getRequestDispatcher("roseFormazione");
			dispacher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long selectedRosa=Long.parseLong(req.getParameter("rosaU"));
		HttpSession session = req.getSession();
		System.out.println(selectedRosa);
		session.setAttribute("rosaCU", selectedRosa);     
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
			List<Giocatore> portieri = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"PORTIERE");
			List<Giocatore> difensori = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"DIFENSORE");
			List<Giocatore> centrocampisti = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"CENTROCAMPISTA");
			List<Giocatore> attaccanti = rdao.findByPrimaryKeyJoinRuolo(selectedRosa,"ATTACCANTE");
			
			req.setAttribute("por", portieri);

			req.setAttribute("dif", difensori);

			req.setAttribute("cen", centrocampisti);

			req.setAttribute("att", attaccanti);
			
			RequestDispatcher dispacher = req.getRequestDispatcher("roseFormazione");
			dispacher.forward(req, resp);
	}
}
