package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.dao.RosaUtenteDao;

public class ControllaUtenteFormazione extends HttpServlet {
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
		
		if(rosaUt.getUtente().getUserName().equals(session.getAttribute("username"))) {
			String uguali="block";
			resp.getWriter().print(uguali);
		}
		else if(!rosaUt.getUtente().getUserName().equals(session.getAttribute("username"))) {
			String uguali="none";
			resp.getWriter().print(uguali);
		}
		
	}

}
