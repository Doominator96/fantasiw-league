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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RosaUtenteDao dao =DatabaseManager.getInstance()
				.getDaoFactory().getRosaUtenteDAO();
			List<RosaUtente> rose = dao.findAll();
			req.setAttribute("rosaUtente", rose);
			String json=new Gson().toJson(rose);
			resp.getWriter().write(json);
			
			
	}
}
