package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.Utente;
import persistence.DAOFactory;
import persistence.PostgresDAOFactory;
import persistence.dao.UtenteDao;

public class CambiaPassword extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String password = req.getParameter("npassword");
		String vpassword= req.getParameter("vpassword");
		Utente ut = PostgresDAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getUtenteDAO().findByCredential(session.getAttribute("username").toString(),
				vpassword);
		UtenteDao utenteDao = PostgresDAOFactory.getInstance().getUtenteDAO();

		System.out.println(ut.getUserName());
		if (ut != null) {
			utenteDao.delete(ut);
			ut.setPassword(password);
			utenteDao.save(ut);
			
			session.setAttribute("password", password);
			System.out.println("password cambiata in: " + ut.getPassword() + " con successo");

		}
		RequestDispatcher dispacher = req.getRequestDispatcher("account.jsp");
		dispacher.forward(req, resp);
	}
}
