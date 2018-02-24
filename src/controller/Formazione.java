package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Formazione {
	
	public void getQuestionsUsingUnirest() throws Exception {
		
		/*
		HttpResponse<JsonNode> response = Unirest.get("https://heisenbug-seriea-live-scores-v1.p.mashape.com/api/serie-a")
				.header("X-Mashape-Key", "lUDpUbfzv2mshXHcOB5yrCbQsSC1p12vEHfjsnCN2RjATLSbVO")
				.header("Accept", "application/json")
				.asJson();
	    //System.out.println(response.getBody().getObject().toString());*/
	    
//		Gson gson = new Gson();
//		String responseJSONString = response.getBody().toString();
		
		
		String string = "{\"matches\":[{\"team1\":{\"teamName\":\"Bologna\"},\"team2\":{\"teamName\":\"Genoa\"},\"when\":\"Saturday, Feb 24 2018 17:00\",\"matchNumber\":26},{\"team1\":{\"teamName\":\"Inter\"},\"team2\":{\"teamName\":\"Benevento\"},\"when\":\"Saturday, Feb 24 2018 19:45\",\"matchNumber\":26}]}";
	
		Pattern patternDate = Pattern.compile("when\":\"\\w+,\\s(\\w+\\s\\d+\\s\\d+)\\s(\\d+\\:\\d+)");
		Pattern patternSquad = Pattern.compile("\"team1\"\\:\\{\"\\w+\":\"(\\w+)\"},\"team2\"\\:\\{\"\\w+\":\"(\\w+)");
		
		Matcher matcher = patternDate.matcher(string);
		Matcher matcherSquad = patternSquad.matcher(string);
		
		if (matcher.find())
		{
		    System.out.println(matcher.group(1)); //stringa risultante
		    System.out.println(matcher.group(2));
		}
		if (matcherSquad.find())
		{
		    System.out.println("Team1"+" "+matcherSquad.group(1)); //stringa risultante
		    System.out.println("Team2"+" "+matcherSquad.group(2));
		}
	   
	  }
	  
	  public static void main(String args[]) throws Exception {
	    Formazione client = new Formazione();
	    client.getQuestionsUsingUnirest();
	  }
	
	
}
