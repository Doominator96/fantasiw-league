package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

public class Formazione2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Formazione formazione = new Formazione();
		try {
			formazione.getQuestionsUsingUnirest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().print(formazione.minDate + "," + formazione.maxDate);
		
		RequestDispatcher dispacher = req.getRequestDispatcher("formazione2.jsp");
		dispacher.forward(req, resp);
//	     URL url = new URL("http://api.football-data.org/v1/competitions/456/leagueTable");
//	        InputStreamReader reader = new InputStreamReader(url.openStream());
//	        MyDto dto = new Gson().fromJson(reader, MyDto.class);
//
//	        // using the deserialized object
//	        System.out.println(dto.headers);
//	        System.out.println(dto.args);
//	        System.out.println(dto.origin);
//	        System.out.println(dto.url);
//	    }
//
//	    private class MyDto {
//	        Map<String, String> headers;
//	        Map<String, String> args;
//	        String origin;
//	        String url;
	    }

}
