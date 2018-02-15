package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

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
		String utenteLoggato = session.getAttribute("username").toString();
		List<Lega> leghe = ldao.findAll();
		req.setAttribute("leghe", leghe);

		RequestDispatcher dispacher = req.getRequestDispatcher("classifica.jsp");
		dispacher.forward(req, resp);

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		LegaDao ldao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
		String utenteLoggato = session.getAttribute("username").toString();
		List<Lega> leghe = ldao.findAll();
		req.setAttribute("leghe", leghe);

		RequestDispatcher dispacher = req.getRequestDispatcher("classifica.jsp");
		dispacher.forward(req, resp);

	}

}