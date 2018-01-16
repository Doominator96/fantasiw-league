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
import java.util.HashMap;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.PostgresDAOFactory;
import persistence.UtenteCredenziali;
import persistence.dao.UtenteDao;

@SuppressWarnings("serial")
public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("login__username");
		String password = req.getParameter("login__password");
		HttpSession session = req.getSession();

		UtenteDao utenteDao = PostgresDAOFactory.getInstance().getUtenteDAO();

		UtenteCredenziali user = UtenteDao.findByPrimaryKeyCredential(username);
		if (user == null) {
			resp.getWriter().print("user");
		}

		else if (!user.getPassword().equals(password)) {
			resp.getWriter().print("password");
		}

		if (session.getAttribute("user") == null)
			session.setAttribute("user", user);

	}
}
