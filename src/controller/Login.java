//package controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import persistence.DatabaseManager;
//import persistence.UtenteCredenziali;
//import persistence.dao.UtenteDao;
//
//public class Login extends HttpServlet{
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
//		HttpSession session=req.getSession();
//		System.out.println(username);
//		System.out.println(password);
//		UtenteDao dao =DatabaseManager.getInstance()
//				.getDaoFactory().getUtenteDAO();
//		
//		UtenteCredenziali user = dao.findByPrimaryKeyCredential(username);
//			
//			if(user == null) {
//				System.out.println("user");
//				resp.getWriter().print("wuser");
//				return;
//			}
//			else if(!user.getPassword().equals(password)) {
//				System.out.println("pass");
//				resp.getWriter().print("wpass");
//				return;
//			}
////			 if(session.getAttribute("username") == null)
////				 session.setAttribute("username", user);
//				System.out.println("else");
//				resp.getWriter().println("true");
//				
//	}
//
//}
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
//			out.println("<script type='text/javascript'>");
//			RequestDispatcher dispatcher = req.getRequestDispatcher("js/swal.js");
//			out.println("</script>");
			
			RequestDispatcher disp;
			disp = req.getRequestDispatcher("/index.jsp");
			disp.forward(req, resp);
		}
	}

}
