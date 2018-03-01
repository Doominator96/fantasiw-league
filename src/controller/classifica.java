package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.dao.RosaUtenteDao;

public class classifica extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long selectedItem=0;
		if(req.getParameter("legas")!=null)
		{
		   selectedItem=Long.parseLong(req.getParameter("legas"));
		}
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
			List<RosaUtente> rose = rdao.findAllLega(selectedItem);//Lega(Long.parseLong(selected_Lega));
			req.setAttribute("rose", rose);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("leghe");
		dispacher.forward(req, resp);
		
		
	
	}
}
