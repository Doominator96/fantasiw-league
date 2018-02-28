package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Lega;
import persistence.DAOFactory;
import persistence.LegaDaoJDBC;
import persistence.PostgresDAOFactory;
import persistence.dao.LegaDao;

public class NomeLega extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String nomeL=req.getParameter("nome");
		Lega lega = PostgresDAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getLegaDAO().findByNome(nomeL);
		LegaDao legaDao = PostgresDAOFactory.getInstance().getLegaDAO();
		
		if (lega != null) {
			resp.getWriter().print("Exist");
		}
		
	}

}
