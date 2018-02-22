package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Lega;
import model.RosaUtente;
import model.Utente;
import persistence.DAOFactory;
import persistence.PostgresDAOFactory;
import persistence.dao.RosaUtenteDao;

public class CreaRosa extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		String nome = req.getParameter("nomeRosa");
		String nomeLega = req.getParameter("nomeLega");
		String passwordLega = req.getParameter("passwordLega");
		RosaUtente rs=new RosaUtente(nome);
		Lega lg=PostgresDAOFactory.getDAOFactory(DAOFactory.POSTGRESQL).getLegaDAO().findByCredential(nomeLega, passwordLega);
		RosaUtenteDao rosaDao=PostgresDAOFactory.getInstance().getRosaUtenteDAO();
		Utente ut=new Utente(session.getAttribute("username").toString(),session.getAttribute("password").toString(),session.getAttribute("email").toString());
		
		if(lg!=null) {
		rs.setLega(lg);
		rs.setUtente(ut);
		rosaDao.save(rs);				  
			session.setAttribute("rosaCorrente", rs);			
			RequestDispatcher dispacher = 
					req.getRequestDispatcher("listaGiocatori");
			dispacher.forward(req, resp);
		}
		else {
			RequestDispatcher disp;
			disp = req.getRequestDispatcher("/home.jsp");
			disp.forward(req, resp);
		}

	
	}
}
