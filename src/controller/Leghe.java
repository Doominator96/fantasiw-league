package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Lega;
import persistence.DatabaseManager;
import persistence.dao.LegaDao;

public class Leghe extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LegaDao dao =DatabaseManager.getInstance()
				.getDaoFactory().getLegaDAO();
			List<Lega> leghe = dao.findAll();
			req.setAttribute("lega", leghe);
			String json=new Gson().toJson(leghe);
			resp.getWriter().write(json);
			
			
	}
}