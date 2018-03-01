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

import model.Lega;
import persistence.DatabaseManager;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;

public class LegheCalcolaFormazione extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		LegaDao ldao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
		
		RosaUtenteDao rdao=DatabaseManager.getInstance().getDaoFactory().getRosaUtenteDAO();
		String utenteLoggato = session.getAttribute("username").toString();
		List<Lega> leghe3 = rdao.findByUtente(utenteLoggato);
		List<Lega> leghe4 = new ArrayList<>();
		for(int i=0;i<leghe3.size();i++) {
			boolean presente=false;
			for(int j=0;j<leghe4.size();j++)
				if(leghe3.get(i).getId()==leghe4.get(j).getId())
					presente=true;
			if(!presente)
				leghe4.add(leghe3.get(i));
		}
		req.setAttribute("leg", leghe4);
		session.setAttribute("leg", leghe4);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("calcolaGiornata.jsp");
		dispatcher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}
}
