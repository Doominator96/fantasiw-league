package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.UtenteCredenziali;
import persistence.dao.RosaUtenteDao;
import persistence.dao.UtenteDao;

public class Login extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("BUONASEERA");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		HttpSession session=req.getSession();
		
		UtenteDao dao =DatabaseManager.getInstance()
				.getDaoFactory().getUtenteDAO();
		
		UtenteCredenziali user = dao.findByPrimaryKeyCredential(username);
			
			if(user == null) {
				resp.getWriter().print("wuser");
				return;
			}
			
			if(!user.getPassword().equals(password)) {
				resp.getWriter().print("wpass");
				return;
			}
			
			if(session.getAttribute("user") == null)
				session.setAttribute("user", user);
			
			System.out.println("CIAO");
			resp.getWriter().print("true");
	}

}
