package controller;
	import java.io.IOException;
import java.io.PrintWriter;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	import model.Utente;
	import persistence.DatabaseManager;
	import persistence.dao.UtenteDao;

	public class Registrazione extends HttpServlet{
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			RequestDispatcher dispacher = 
					req.getRequestDispatcher("registrazione.jsp");
			dispacher.forward(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String username = req.getParameter("username");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
				Utente ut = 
						new Utente(username,email,password);
				
				UtenteDao utenteDao = 
						DatabaseManager.getInstance()
						.getDaoFactory().getUtenteDAO();
				utenteDao.save(ut);
				utenteDao.setPassword(ut, password);
				
				req.setAttribute("utente", ut);
				
				RequestDispatcher dispacher = 
						req.getRequestDispatcher("registrazione.jsp");
				dispacher.forward(req, resp);
				
//              resp.setContentType("text/html");
				
				
//				PrintWriter out = resp.getWriter();
//				out.println("<html>");
//				out.println("<head><title>Registrazione</title></head>");
//				out.println("<body>");
//				out.println("<h1>Abbiamo registrato l'utente:</h1>");
//				out.println(email);
//				out.println(username);
//				out.println(password);
//				out.println("</body>");
//				out.println("</html>");	
			
				
		}
	}
