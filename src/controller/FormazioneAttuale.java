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

import org.json.JSONArray;

import model.Lega;
import persistence.DatabaseManager;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;

public class FormazioneAttuale extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		LegaDao ldao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
		
		RosaUtenteDao rdao=DatabaseManager.getInstance().getDaoFactory().getRosaUtenteDAO();
		String utenteLoggato = session.getAttribute("username").toString();
		List<Lega> leghe = rdao.findByUtente(utenteLoggato);
		List<Lega> leghe2 = new ArrayList<>();
		for(int i=0;i<leghe.size();i++) {
			boolean presente=false;
			for(int j=0;j<leghe2.size();j++)
				if(leghe.get(i).getId()==leghe2.get(j).getId())
					presente=true;
			if(!presente)
				leghe2.add(leghe.get(i));
		}
		String lg=(new JSONArray(leghe2).toString());
		resp.getWriter().print(lg);
		req.setAttribute("leghe", leghe2);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("classifica.jsp");
		dispacher.forward(req, resp);
	}
}
