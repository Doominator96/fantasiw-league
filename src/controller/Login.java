
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import javafx.scene.control.Alert;
import model.Utente;
import persistence.DAOFactory;
import persistence.PostgresDAOFactory;
import persistence.UtenteCredenziali;
import persistence.dao.UtenteDao;

@SuppressWarnings("serial")
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		String username = req.getParameter("login_username");
		String password = req.getParameter("login_password");

		Utente ut = PostgresDAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getUtenteDAO().findByCredential(username,
				password);

		req.setAttribute("wrong", false);

		if (ut != null) {
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("email", ut.getEmail());
			session.setAttribute("loggato", true);
			req.setAttribute("loggato", true);

				session.setAttribute("utente", ut);
			req.setAttribute("utente", ut);

			RequestDispatcher disp;
			disp = req.getRequestDispatcher("/home.jsp");
			disp.forward(req, resp);
		} else {
		    req.setAttribute("wrong", true);
			
			RequestDispatcher disp;
			disp = req.getRequestDispatcher("/index.jsp");
			disp.forward(req, resp);
		}
	}

}
