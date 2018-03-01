package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import model.Giocatore;
import model.Lega;
import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.dao.RosaUtenteDao;

public class GiocatoriRosa extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		long selectedRosa=0;
		if(req.getParameter("rose1")!=null)
		{
			   selectedRosa=Long.parseLong(req.getParameter("rose1"));
		}
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
		RosaUtente rosaUt=rdao.findByPrimaryKey(selectedRosa);
		Lega lega=(Lega) session.getAttribute(""+rosaUt.getLega().getId());
			List<Giocatore> giocatori=rdao.findByPrimaryKeyFormazione(selectedRosa);
			if(lega!=null)
			for(int i=0;i<giocatori.size();i++) {
				giocatori.get(i).setStatistiche(lega.getStats(giocatori.get(i).getId()));
				giocatori.get(i).calcolaVotoHashMap();
			}
			req.setAttribute("giocatori", giocatori);
			String players = (new JSONArray(giocatori).toString());
			resp.getWriter().print(players);
		
		
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long selectedRosa=0;
		if(req.getParameter("rose1")!=null)
		{
		   selectedRosa=Long.parseLong(req.getParameter("rose1"));
		}
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
			List<Giocatore> giocatori=rdao.findByPrimaryKeyJoin(selectedRosa);
			req.setAttribute("giocatori", giocatori);
			
			String players = (new JSONArray(giocatori).toString());
			resp.getWriter().print(players);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("roseUtente");
		dispacher.forward(req, resp);
		
	}
}
