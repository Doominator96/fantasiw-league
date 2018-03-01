package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Formazione2 extends HttpServlet {
	
	Date maxDate = null;
	Date minDate = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			/*
			 * HttpResponse<JsonNode> response = Unirest.get(
			 * "https://heisenbug-seriea-live-scores-v1.p.mashape.com/api/serie-a?matchday=1")
			 * .header("X-Mashape-Key",
			 * "lUDpUbfzv2mshXHcOB5yrCbQsSC1p12vEHfjsnCN2RjATLSbVO") .header("Accept",
			 * "application/json") .asJson();
			 * //System.out.println(response.getBody().getObject().toString());
			 */
			
			HttpResponse<JsonNode> response = Unirest.get("http://api.football-data.org/v1/competitions/456/leagueTable")
					.header("X-Auth-Token", "c2dc16848c4c4607a87ea9bcbd4cd2f4")
					.header("Accept", "application/json").asJson();
			
			
			Date oggi = new Date(); // Data di oggi

			SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd"); // Qui decido il formato di visualizzazione
			System.out.println( sdf.format( oggi ) );
			
			String footballApiMD = response.getBody()
					.toString();
			String matchDay = null;
			Pattern patternMD = Pattern.compile("matchday=(\\d+)");
			Matcher matcherMD = patternMD.matcher(footballApiMD);
			if (matcherMD.find()) // trovo tutti i match
			{
				System.out.println(matcherMD.group(1));
				matchDay = matcherMD.group(1);
			}
			// Gson gson = new Gson();
			// String responseJSONString = response.getBody().toString();
			String string = "{\r\n" + "  \"matches\": [\r\n" + "    {\r\n"
					+ "      \"when\": \"Sunday, Feb 25 2018 14:00\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Sampdoria\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Udinese\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Sunday, Feb 25 2018 14:00\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Verona\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Torino\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Sunday, Feb 25 2018 11:30\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Crotone\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"SPAL 2013\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Monday, Feb 26 2018 19:45\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Cagliari\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Napoli\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Sunday, Feb 25 2018 19:45\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Roma\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"AC Milan\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Sunday, Feb 25 2018 14:00\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Sassuolo\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Lazio\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Saturday, Feb 24 2018 17:00\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Bologna\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Genoa\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Sunday, Feb 25 2018 17:00\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Juventus\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Atalanta\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Saturday, Feb 24 2018 19:45\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Inter\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Benevento\"\r\n" + "      }\r\n" + "    },\r\n" + "    {\r\n"
					+ "      \"when\": \"Sunday, Feb 25 2018 14:00\",\r\n" + "      \"team1\": {\r\n"
					+ "        \"teamName\": \"Fiorentina\"\r\n" + "      },\r\n" + "      \"team2\": {\r\n"
					+ "        \"teamName\": \"Chievo\"\r\n" + "      }\r\n" + "    }\r\n" + "  ]\r\n" + "}\r\n" + "";
			
			/*
			 * Matcha tutte le date risultanti dal json dell'API che le prende dalla
			 * prossima giornata di Serie A.
			 */
			// Pattern patternDate =
			// Pattern.compile("when\"\\:\\s+\"\\w+,\\s+(\\w+\\s+\\d+\\s+\\d+)");
			
			String footballApiDate = Unirest
					.get("http://api.football-data.org/v1/competitions/456/fixtures?matchday=" + 27) //matchDay
					.header("X-Auth-Token", "c2dc16848c4c4607a87ea9bcbd4cd2f4")
					.header("Accept", "application/json").asJson().getBody()
					.toString();
			Pattern patternDate = Pattern.compile("date\":\"(\\d+-\\d+-\\d+)");
			
			/*
			 * Matcha tutte le coppie di squadre che si affronteranno, risultanti dal json
			 * dell'API che le prende dalla prossima giornata di Serie A.
			 */
			Pattern patternSquad = Pattern.compile(
					"\"team1\"\\:\\s+\\{\\s+\"\\w+\\\"\\:\\s+\"(\\w+)\"\\s+\\}.\\s+\"team2\":\\s+\\{\\s+\"\\w+\\\"\\:\\s+\"(\\w+\\s*\\w*)");
			
			Matcher matcherDate = patternDate.matcher(footballApiDate);
			
			// Matcher matcherDate = patternDate.matcher(string);
			Matcher matcherSquad = patternSquad.matcher(string);
			
			ArrayList<Date> dates = new ArrayList<>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			while (matcherDate.find()) // trovo il primo match
			{
				Date date = new Date();
				// System.out.println(matcherDate.group(1));
				date = dateFormat.parse(matcherDate.group(1));
				dates.add(date);
				maxDate = dates.stream().max(Date::compareTo).get();
				minDate = dates.stream().min(Date::compareTo).get();
			}
			System.out.println(maxDate);
			System.out.println(minDate);
			
			// while (matcherSquad.find()) //trovo tutti i match
			// {
			// System.out.println("Team1"+" "+matcherSquad.group(1));
			// System.out.println("Team2"+" "+matcherSquad.group(2));
			// }
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().print(minDate + "," + maxDate);
		
	}
		


}
