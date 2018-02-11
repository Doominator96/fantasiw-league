package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpServer;

import model.Lega;
import model.Utente;
import persistence.PostgresDAOFactory;
import persistence.dao.LegaDao;
import persistence.dao.UtenteDao;

public class CreaLega extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String nome = req.getParameter("nome");
		String password = req.getParameter("password");
		Lega lg=new Lega(nome,password);
		LegaDao legaDao = PostgresDAOFactory.getInstance().getLegaDAO();	
		legaDao.save(lg);				  
			session.setAttribute("lega", lg);
			System.out.println("Lega: "+lg.getNome() + " creata con successo");
			
			RequestDispatcher dispacher = 
					req.getRequestDispatcher("home.jsp");
			dispacher.forward(req, resp);
			

	
	}
}
