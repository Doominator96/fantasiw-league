package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;

import model.Lega;
import persistence.DatabaseManager;
import persistence.dao.LegaDao;

public class Leghe extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		LegaDao dao = DatabaseManager.getInstance().getDaoFactory().getLegaDAO();
		String utenteLoggato=session.getAttribute("username").toString();
		List<Lega> leghe = dao.findByUtente(utenteLoggato);
		req.setAttribute("lega", leghe);
		String json = new Gson().toJson(leghe);
		resp.getWriter().write(json);

	}
	// protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// StringBuffer jsonReceived = new StringBuffer();
	// BufferedReader reader = new BufferedReader(new
	// InputStreamReader(req.getInputStream()));
	// String line = reader.readLine();
	// while (line != null){
	// jsonReceived.append(line);
	// line = reader.readLine();
	// }
	// System.out.println(jsonReceived.toString());
	// try {
	// JSONObject json = new JSONObject(jsonReceived.toString());
	// Studente studente = new Studente();
	// studente.setMatricola(json.getString("matricola"));
	// studente.setCognome(json.getString("cognome"));
	// studente.setNome(json.getString("nome"));
	//
	// StudenteDao dao =DatabaseManager.getInstance()
	// .getDaoFactory().getStudenteDAO();
	// Studente dbStudente = dao.findByPrimaryKey(studente.getMatricola());
	//
	// JSONObject jsonIndirizzo = new JSONObject(dbStudente.getIndirizzo());
	//
	// PrintWriter out = resp.getWriter();
	// out.println(jsonIndirizzo.toString());
	// } catch (JSONException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}