package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.Lega;
import model.RosaUtente;
import persistence.DatabaseManager;
import persistence.dao.LegaDao;
import persistence.dao.RosaUtenteDao;

public class Leghe extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		LegaDao ldao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
		
		RosaUtenteDao rdao=DatabaseManager.getInstance().getDaoFactory().getRosaUtenteDAO();
		String utenteLoggato = session.getAttribute("username").toString();
		List<Lega> leghe = rdao.findByUtente(utenteLoggato);
		List<Lega> leghe2 = new ArrayList<>();
		for(int i=0;i<leghe.size();i++) {
			boolean presente=false;
			for(int j=0;j<leghe2.size();j++)
				if(leghe.get(i).getId()==leghe2.get(j).getId())
					presente=true;
			if(!presente)
				leghe2.add(leghe.get(i));
		}
		req.setAttribute("leghe", leghe2);

		RequestDispatcher dispacher = req.getRequestDispatcher("classifica.jsp");
		dispacher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}