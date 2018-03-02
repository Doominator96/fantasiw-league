package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.dao.RosaUtenteDao;

public class AzzeraCalcolato extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RosaUtenteDao rdao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
		List<RosaUtente> roseTot=rdao.findAll();
		
		for(int i=0;i<roseTot.size();i++)
			rdao.setCalcolato(roseTot.get(i).getId(), 0);
		
		System.out.println("CalcoloDisponibile");
	}

}
