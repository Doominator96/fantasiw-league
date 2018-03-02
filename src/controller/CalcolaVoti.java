package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Giocatore;
import model.Lega;
import persistence.DatabaseManager;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;

public class CalcolaVoti extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long rosaSelezionata=Long.parseLong(req.getParameter("rose1"));
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
		if(rdao.findByPrimaryKey(rosaSelezionata).getGiornataPrec()!=0) {
			resp.getWriter().print("calcolata");
		}
		else {
		String legaSelezionata=(String) req.getParameter("legaSel");		
		HttpSession session=req.getSession();
		LegaDao ldao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
		Lega leg=ldao.findByPrimaryKey(Long.parseLong(legaSelezionata));
		List<Giocatore> giocatoriLega =ldao.findByPrimaryKeyLega(Long.parseLong(legaSelezionata));
		for(int i=0;i<giocatoriLega.size();i++) {
			giocatoriLega.get(i).calcolaVoto();
			leg.add(giocatoriLega.get(i).getStatistiche(),giocatoriLega.get(i).getId());
		}
		session.setAttribute(""+leg.getId(), leg);		
		}
		}
}
