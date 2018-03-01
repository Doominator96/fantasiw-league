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

public class RoseCalcolaFormazione extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		RosaUtenteDao rdao = DatabaseManager.getInstance().getDaoFactory().getRosaUtenteDAO();
		
		List<RosaUtente> roseL = rdao.findAllLega(Long.parseLong(req.getParameter("legaSel")));
		session.setAttribute("roseL", roseL);

		String rosL=(new JSONArray(roseL).toString());  
		resp.getWriter().print(rosL);
//		RequestDispatcher dispacher = req.getRequestDispatcher("legheCalcolaFormazione");
//		dispacher.forward(req, resp);
		
}
}
