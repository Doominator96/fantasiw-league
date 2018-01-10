package controller;
	import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import persistence.PostgresDAOFactory;
import model.Utente;
import persistence.dao.UtenteDao;

	public class Registra extends HttpServlet{
		
//		@Override
//		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//				throws ServletException, IOException {
//			RequestDispatcher dispacher = 
//					req.getRequestDispatcher("index.html");
//			dispacher.forward(req, resp);
//		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("fzdsfdsad");
			HttpSession session=req.getSession();
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
				Utente ut = 
						new Utente(username,email,password);
				UtenteDao utenteDao =PostgresDAOFactory.getInstance().getUtenteDAO();						
				utenteDao.save(ut);
				utenteDao.setPassword(ut, password);
				
				  
				session.setAttribute("utente", ut);
				
				RequestDispatcher dispacher = 
						req.getRequestDispatcher("index.html");
				dispacher.forward(req, resp);
				
              resp.setContentType("text/html");
				
				
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head><title>Registrazione</title></head>");
				out.println("<body>");
				out.println("<h1>Abbiamo registrato l'utente:</h1>");
				out.println(email);
				out.println(username);
				out.println(password);
				out.println("</body>");
				out.println("</html>");	
		
		}
	}
