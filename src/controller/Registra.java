package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistence.PostgresDAOFactory;
import model.Utente;
import persistence.dao.UtenteDao;

public class Registra extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpSession session=req.getSession();
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UtenteDao utenteDao = PostgresDAOFactory.getInstance().getUtenteDAO();
		if(utenteDao.findByPrimaryKey(username)!=null) {
				req.setAttribute("esistente", true);
				
				RequestDispatcher dispacher = req.getRequestDispatcher("registrazione.jsp");
				dispacher.forward(req, resp);
		}
		else {
		Utente ut = new Utente(username, email, password);
		utenteDao.save(ut);
		utenteDao.setPassword(ut, password);

		// session.setAttribute("utente", ut);
		System.out.println("utente: " + ut.getUserName() + " registrato con successo");

		RequestDispatcher dispacher = req.getRequestDispatcher("index.jsp");
		dispacher.forward(req, resp);
		}
	}
}
